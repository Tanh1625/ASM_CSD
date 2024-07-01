
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */

public class Vertex {
    String label;
    HashMap<Vertex, Integer> adjList;
//    ArrayList<Vertex> adjlist;

    public Vertex(String label) {
        this.label = label;
        this.adjList = new HashMap<>();
    }
    
}
