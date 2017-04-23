/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravegoldapp;

import gravegoldapp.controller.HandlerEnvironment;
import gravegoldapp.model.Environment;
import gravegoldapp.model.Node;

/**
 *
 * @author beepi
 */
public class GraveGoldApp {

    public static void main(String[] args) throws IllegalArgumentException {
        HandlerEnvironment handler = HandlerEnvironment.getInstant();
        Environment enviroment = handler.initialEnvironment();
        for(Node node : enviroment.getNodes()){
            System.out.print(node.toString() + "\n \n");
        }
    }
}
