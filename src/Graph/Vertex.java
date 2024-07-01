/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

/**
 *
 * @author ACER
 */
import java.util.HashMap;
import java.util.List;
public class Vertex {
    String label;
    HashMap<Vertex,Integer>adjList;
    public Vertex(String label) {
        this.label = label;
        this.adjList= new HashMap<>();
    }
    
}
