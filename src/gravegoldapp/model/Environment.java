/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravegoldapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * define environment which includes postion of wumpus, gold and pits, the
 * number of pits
 *
 * @author beepi
 */
public class Environment {

    private int mPosWumpus;
    private int mPosGold;
    private int mNumberOfPits;
    private List<Integer> mPosPits;
    private List<Node> mNodes = new ArrayList();

    public Environment(int posWumpus, int posGold,
            int numberOfPits, List<Integer> posPits) {
        mPosWumpus = posWumpus;
        mPosGold = posGold;
        mNumberOfPits = numberOfPits;
        mPosPits = posPits;
    }

    public int getPosWumpus() {
        return mPosWumpus;
    }

    public void setPosWumpus(int posWumpus) {
        this.mPosWumpus = posWumpus;
    }

    public int getPosGold() {
        return mPosGold;
    }

    public void setPosGold(int posGold) {
        this.mPosGold = posGold;
    }

    public int getNumberOfPits() {
        return mNumberOfPits;
    }

    public void setNumberOfPits(int numberOfPits) {
        this.mNumberOfPits = numberOfPits;
    }

    public List<Integer> getPosPits() {
        return mPosPits;
    }

    public void setPosPits(List<Integer> posPits) {
        this.mPosPits = posPits;
    }

    public List<Node> getNodes() {
        return mNodes;
    }

    public Node findNodeByPosition(int postion) {
        for (Node node : mNodes) {
            if (node.getPosition() == postion) {
                return node;
            }
        }
        return null;
    }
}
