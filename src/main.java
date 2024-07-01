/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
         graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        
        graph.addEdgeBiDirection("A", "B", 5);
        graph.addEdgeBiDirection("A", "C", 2);
        graph.addEdgeBiDirection("A", "H", 2);
        graph.addEdgeBiDirection("B", "C", 5);
        graph.addEdgeBiDirection("B", "G", 3);
        graph.addEdgeBiDirection("B", "E", 4);
        graph.addEdgeBiDirection("B", "F", 2);
        graph.addEdgeBiDirection("C", "D", 1);
        graph.addEdgeBiDirection("C", "E", 1);
        graph.addEdgeBiDirection("D", "E", 4);
        graph.addEdgeBiDirection("D", "I", 1);
        graph.addEdgeBiDirection("E", "F", 1);
        graph.addEdgeBiDirection("E", "I", 2);
        graph.addEdgeBiDirection("F", "I", 2);
        graph.addEdgeBiDirection("F", "G", 5);
        graph.addEdgeBiDirection("G", "H", 3);
       
//        graph.display();
        
//        graph.BFS_thay("A");
//        graph.DFS("A");
//graph.dijkastra("A", "F");
      Graph newGr = graph.primJanik(graph, "A");
      newGr.display();
    }
    
}
