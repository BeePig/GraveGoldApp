package gravegoldapp.controller;

import gravegoldapp.model.Agent;
import gravegoldapp.model.Environment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import gravegoldapp.model.Node;
import gravegoldapp.until.Constant;
import gravegoldapp.until.Label.LABEL;

/**
 * set up environment for agent
 *
 * @author beepi
 */
public class HandlerEnvironment {
    
    private int mPosWumpusPit = -1;
    private static HandlerEnvironment sHandler;
    
    public static HandlerEnvironment getInstant() {
        if (sHandler == null) {
            sHandler = new HandlerEnvironment();
        }
        return sHandler;
    }
    
    public Environment initialEnvironment() {
        Environment environment = inputData();
        setupNodes(environment);
        return environment;
    }

    /**
     * receive data from keyboard include postion of gold, wumpus,pit and the
     * number of pits
     *
     * @return
     */
    private Environment inputData() {
        Scanner scaner = new Scanner(System.in);
        int posWumpus = -1, posGold = -1, numberOfPits = 0;
        List<Integer> posPits = new ArrayList<>();
        while (posWumpus <= 0 || posWumpus > 15 || posGold == posWumpus) {
            System.out.print("Enter your postion of wumpus, "
                    + "the postion is not greater than 15 and not smaller than 0. "
                    + "Specially, postion of gold and wumpus is not the same \n");
            posWumpus = scaner.nextInt();
        }
        while (posGold <= 0 || posGold > 15 || posGold == posWumpus) {
            System.out.print("Enter your postion of gold, "
                    + "the postion is not greater than 15 and not smaller than 0. "
                    + "Specially, postion of gold and wumpus is not the same \n");
            posGold = scaner.nextInt();
        }
        while (numberOfPits <= 0 || numberOfPits > 5) {
            System.out.print("Enter the number of pits, "
                    + "the number is not greater than 5 and not smaller than 0 \n");
            numberOfPits = scaner.nextInt();
        }
        
        for (int i = 0; i < numberOfPits; i++) {
            int posPit = -1;
            while (posPit <= 0 || posPit > 15 || posPit == posGold) {
                System.out.print("Enter your postion of pit,the number "
                        + "is not greater than 15 and not smaller than 0."
                        + " Specially, postion of pit is not "
                        + "the same postion of gold \n");
                posPit = scaner.nextInt();
                if (posPit == posWumpus) {
                    mPosWumpusPit = posPit;
                }
            }
            posPits.add(posPit);
        }
        return new Environment(posWumpus, posGold, numberOfPits, posPits);
    }

    /**
     * set up node of {@link Environment}
     *
     * @param environment environment of the agent {@link Agent}
     */
    private void setupNodes(Environment environment) {
        Node wumpusNode, goldNode, node, pitNode;
        for (int i = 0; i < 16; i++) {
            node = Node.createNode(i);
            environment.getNodes().add(node);
        }
        for (int i = 0; i < 16; i++) {
            setupNeighborNode(environment.findNodeByPosition(i), environment);
        }
        if (mPosWumpusPit >= 0) {
            wumpusNode = environment.findNodeByPosition(mPosWumpusPit);
            wumpusNode.setLabel(LABEL.WUMPUS_PIT);
        }
        wumpusNode = environment.findNodeByPosition(environment.getPosWumpus());
        wumpusNode.setLabel(LABEL.WUMPUS);
        setupNeighborNode(wumpusNode, environment);
        goldNode = environment.findNodeByPosition(environment.getPosGold());
        goldNode.setLabel(LABEL.GOLD);
        setupNeighborNode(goldNode, environment);
        if (environment.getNumberOfPits() == 0) {
            return;
        }
        for (int pitPos : environment.getPosPits()) {
            if (pitPos == mPosWumpusPit) {
                continue;
            }
            pitNode = environment.findNodeByPosition(pitPos);
            pitNode.setLabel(LABEL.PIT);
            setupNeighborNode(pitNode, environment);
        }
    }

    /**
     * set up for the neighbor for each node in environment
     *
     * @param currentNode: currently node
     * @param environment: environment includes currentNode
     */
    private void setupNeighborNode(Node currentNode, Environment environment) {
        Node leftNode, rightNode, upperNode, bottomNode;
        int currentPos = currentNode.getPosition();
        leftNode = environment.findNodeByPosition(currentPos - 1);
        rightNode = environment.findNodeByPosition(currentPos + 1);
        upperNode = environment.findNodeByPosition(currentPos - 4);
        bottomNode = environment.findNodeByPosition(currentPos + 4);
        switch (currentNode.getLabel()) {
            case WUMPUS:
                if (leftNode != null) {
                    leftNode.setLabel(LABEL.NEAR_WUMPUS);
                }
                if (rightNode != null) {
                    rightNode.setLabel(LABEL.NEAR_WUMPUS);
                }
                if (upperNode != null) {
                    upperNode.setLabel(LABEL.NEAR_WUMPUS);
                }
                if (bottomNode != null) {
                    bottomNode.setLabel(LABEL.NEAR_WUMPUS);
                }
                break;
            case PIT:
                if (leftNode != null) {
                    leftNode.setLabel(LABEL.NEAR_PIT);
                }
                if (rightNode != null) {
                    rightNode.setLabel(LABEL.NEAR_PIT);
                }
                if (upperNode != null) {
                    upperNode.setLabel(LABEL.NEAR_PIT);
                }
                if (bottomNode != null) {
                    bottomNode.setLabel(LABEL.NEAR_PIT);
                }
                break;
            case WUMPUS_PIT:
                if (leftNode != null) {
                    leftNode.setLabel(LABEL.NEAR_WUMPUS_PIT);
                }
                if (rightNode != null) {
                    rightNode.setLabel(LABEL.NEAR_WUMPUS_PIT);
                }
                if (upperNode != null) {
                    upperNode.setLabel(LABEL.NEAR_WUMPUS_PIT);
                }
                if (bottomNode != null) {
                    bottomNode.setLabel(LABEL.NEAR_WUMPUS_PIT);
                }
                break;
            default:
                currentNode.setLeftNode(leftNode);
                currentNode.setRightNode(rightNode);
                currentNode.setUpperNode(upperNode);
                currentNode.setBottomNode(bottomNode);
                break;
            
        }
    }
    
}
