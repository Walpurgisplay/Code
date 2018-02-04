//==============================================================
 // Shortest Path Program
 //==============================================================
 // James Ream
 // COSC 336.001
 // 5/16/17
 //--------------------------------------------------------------


import java.util.*;

public class ShortestPath {
  public static void main(String[] args) {
    // 0=A, 1=B, etc.
    AdjacencyList graph = new AdjacencyList(8);
    
    //BUILD GRAPH
    graph.addEdge(0, 1, 1);
    graph.addEdge(0, 5, 8);
    graph.addEdge(0, 4, 4);
    graph.addEdge(1, 2, 2);
    graph.addEdge(1, 6, 6);
    graph.addEdge(1, 5, 8);
    graph.addEdge(2, 3, 1);
    graph.addEdge(2, 6, 2);
    graph.addEdge(3, 6, 1);
    graph.addEdge(3, 7, 4);
    graph.addEdge(4, 5, 5);
    graph.addEdge(6, 5, 1);
    graph.addEdge(6, 7, 1);
    
    graph.printAdjacencyList();
    
    graph.dijkstra(0);
    
    AdjacencyList graph2 = new AdjacencyList(8);
    
    graph.addEdge(0, 1, -1);
    graph.addEdge(0, 5, 8);
    graph.addEdge(0, 4, 4);
    graph.addEdge(1, 2, -2);
    graph.addEdge(1, 6, 6);
    graph.addEdge(1, 5, 8);
    graph.addEdge(2, 3, 1);
    graph.addEdge(2, 6, 2);
    graph.addEdge(3, 6, 1);
    graph.addEdge(3, 7, 4);
    graph.addEdge(4, 5, 5);
    graph.addEdge(6, 5, 1);
    graph.addEdge(6, 7, -1);
    
    graph.bellmanFord(0);
    
    
    
  }
  
  
  
  
  
}