package Graph;


import Graph.Edge;
import Graph.ArrayStack;
import Graph.ArrayQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell
 */
public class Graph {

    Set<Vertex> vertices;

    public Graph() {
        this.vertices = new HashSet<>();
    }

    public Vertex getVertex(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    public Vertex addVertex(String v) {
        Vertex newV = new Vertex(v);
        this.vertices.add(newV);
        return newV;

    }

    public void addEdge(String u, String v, int weight) {
        Vertex vertexU = this.getVertex(u);
        Vertex vertexV = this.getVertex(v);
        if (vertexU == null) {
            vertexU = this.addVertex(u);
        }
        if (vertexV == null) {
            vertexV = this.addVertex(v);
        }
        vertexU.adjList.put(vertexV, weight);
    }

    public void addEdgeBiDirection(String u, String v, int weight) {
//        Vertex vertexU = this.getVertex(u);
//        Vertex vertexV = this.getVertex(v);
//        if (vertexU == null) {
//            return;
//        }
//        if (vertexV == null) {
//            this.vertices.add(new Vertex(v));
//        }
//        //vertexU.adjList.add(vertexV);
//        vertexU.adjList.put(vertexV, weight);
//        vertexV.adjList.put(vertexU, weight);
        addEdge(u, v, weight);
        addEdge(v, u, weight);
    }

    public void display() {
        this.vertices.stream().forEach(vertex -> {
            System.out.print(vertex.label + " -> ");
            vertex.adjList.entrySet().forEach(entry
                    -> System.out.print("(" + entry.getKey().label + " " + entry.getValue() + ") "));
            System.out.println();
        });
    }

    public void BFS_thay(String starVertex) {
        ArrayQueue<Vertex> queue = new ArrayQueue<>(1000);
        queue.enQueue(this.getVertex(starVertex));
        ArrayList<Vertex> visited = new ArrayList<>();
        while (!queue.isEmpty()) {
            Vertex current = queue.deQueue();
            if (!visited.contains(current)) {
                System.out.print(current.label + " ");

                current.adjList.entrySet().stream().forEach(entry -> {
                    if (!visited.contains(entry.getKey())) {
                        queue.enQueue(entry.getKey());
                    }
                });
            }
            visited.add(current);
        }
        System.out.println("");

    }

    public void DFS(String label) {
        ArrayList<Vertex> visited = new ArrayList<>();
        ArrayStack<Vertex> stack = new ArrayStack<>(100);
        stack.push(this.getVertex(label));
        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex.label + " ");
                currentVertex.adjList.entrySet().forEach(entry -> stack.push(entry.getKey()));
            }
            visited.add(currentVertex);
        }
    }

    public void dijkastra(String start, String destination) {
        HashMap<Vertex, Integer> distance = new HashMap<>();
        this.vertices.stream().forEach(Vertex -> distance.put(Vertex, Integer.MAX_VALUE));
        HashMap<Vertex, Vertex> previous = new HashMap<>();
        ArrayQueue<Vertex> queue = new ArrayQueue<>(1000);
        ArrayList<Vertex> visited = new ArrayList<>();
        Vertex startVertex = this.getVertex(start);
        queue.enQueue(startVertex);
        distance.put(startVertex, 0);
        previous.put(startVertex, startVertex);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.deQueue();
//            distance.entrySet().stream().forEach(entry->
//                    System.out.print("("+entry.getKey().label+","+entry.getValue()+")"));
//            System.out.println();
            if (!visited.contains(currentVertex)) {
                currentVertex.adjList.entrySet().stream().forEach(entry -> {
                    int totalDistance = distance.get(currentVertex) + entry.getValue();
                    if (totalDistance < distance.get(entry.getKey())) {
                        distance.put(entry.getKey(), totalDistance);
                        previous.put(entry.getKey(), currentVertex);
                    }
                    if (!visited.contains(entry.getKey())) {
                        queue.enQueue(entry.getKey());

                    }
                });
            }
            visited.add(currentVertex);
        }
        Vertex destVertex = this.getVertex(destination);
        if (destVertex == null || distance.get(destVertex) == Integer.MAX_VALUE) {
            System.out.println("No path found from " + start + " to " + destination);
        } else {
            System.out.println("Shortest path from " + start + " to " + destination + " is " + distance.get(destVertex));
            ArrayList<Vertex> path = getPath(previous, startVertex, destVertex);
            System.out.print("Path: ");
            for (Vertex vertex : path) {
                System.out.print(vertex.label + " ");
            }
            System.out.println();
        }

    }

    private ArrayList<Vertex> getPath(HashMap<Vertex, Vertex> previous, Vertex startVertex, Vertex destinationVertex) {
        ArrayList<Vertex> path = new ArrayList<>();
        Vertex currentVertex = destinationVertex;

        // If there's no path from start to destination
        if (!previous.containsKey(destinationVertex)) {
            return path; // Return an empty path
        }

        // Trace the path from destination to start
        while (currentVertex != null && !currentVertex.equals(startVertex)) {
            path.add(currentVertex);
            currentVertex = previous.get(currentVertex);
        }

        // Add the start vertex at the end
        if (currentVertex != null) {
            path.add(startVertex);
        }

        // Reverse the path to get it from start to destination
        Collections.reverse(path);
        return path;
    }

//    public Graph primJanik(Graph g, String start) {
//        Graph mst = new Graph();
//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
//        List<Vertex> visited = new ArrayList<>();
//        Vertex startVertex = g.getVertex(start);
//
//        visited.add(startVertex);
//        startVertex.adjList.forEach((adjVertex, weight) -> priorityQueue.add(new Edge(startVertex, adjVertex, weight)));
//        while (!priorityQueue.isEmpty()) {
//            Edge minEdge = priorityQueue.poll();
//            if (!visited.contains(minEdge.to)) {
//                mst.addEdgeBiDirection(minEdge.from.label, minEdge.to.label, minEdge.weight);
//                minEdge.to.adjList.forEach((adjVertex, weight) -> priorityQueue.add(new Edge(minEdge.to, adjVertex, weight)));
//            }
//            visited.add(minEdge.to);
//        }
//        return mst;
//
//    }
public Graph primJanik(Graph g, String start) {
    Graph mst = new Graph();
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
    Set<Vertex> visited = new HashSet<>();
    Vertex startVertex = g.getVertex(start);

    // Add the start vertex to the visited set and add its edges to the priority queue
    visited.add(startVertex);
    for (Map.Entry<Vertex, Integer> entry : startVertex.adjList.entrySet()) {
        priorityQueue.add(new Edge(startVertex, entry.getKey(), entry.getValue()));
    }

    while (!priorityQueue.isEmpty()) {
        Edge minEdge = priorityQueue.poll();
        if (!visited.contains(minEdge.to)) {
            // Add the edge to the MST
            mst.addEdgeBiDirection(minEdge.from.label, minEdge.to.label, minEdge.weight);
            // Mark the vertex as visited
            visited.add(minEdge.to);
            // Add all edges of the new vertex to the priority queue
            for (Map.Entry<Vertex, Integer> entry : minEdge.to.adjList.entrySet()) {
                if (!visited.contains(entry.getKey())) {
                    priorityQueue.add(new Edge(minEdge.to, entry.getKey(), entry.getValue()));
                }
            }
        }
    }
    return mst;
}

//public void removeEdge(String u, String v){
//Vertex vertexU = this.getVertex(u);
//Vertex vertexV = this.getVertex(v);
//if()
//
//
//}

}