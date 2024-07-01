/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Graph.Graph;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Graph myG = new Graph();
        myG.addVertex("A");
        myG.addVertex("B");
        myG.addVertex("C");
        myG.addVertex("D");
        myG.addVertex("E");
        myG.addVertex("F");

        myG.addVertex("G");
        myG.addVertex("H");
        myG.addVertex("I");
        
//               myG.addEdgeDirection("A", "B", 5);
//        myG.addEdgeDirection("A", "C", 2);
//        myG.addEdgeDirection("A", "H", 2);
//        myG.addEdgeDirection("B", "C", 5);
//        myG.addEdgeDirection("B", "G", 3);
//        myG.addEdgeDirection("B", "E", 4);
//        myG.addEdgeDirection("B", "F", 2);
//        myG.addEdgeDirection("C", "D", 1);
//        myG.addEdgeDirection("C", "E", 1);
//        myG.addEdgeDirection("D", "E", 4);
//        myG.addEdgeDirection("D", "I", 1);
//        myG.addEdgeDirection("E", "F", 1);
//        myG.addEdgeDirection("E", "I", 2);
//        myG.addEdgeDirection("F", "I", 2);
//        myG.addEdgeDirection("F", "G", 5);
//        myG.addEdgeDirection("G", "H", 3);
//        myG.Dijkstra("A", "F");
//        

        myG.display();
       
        myG.bfs("A");
        myG.dfs("A");
    }
}
