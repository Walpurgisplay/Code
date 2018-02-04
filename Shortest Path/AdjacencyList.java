import java.util.*;
import javafx.util.*;
import java.lang.*;

public class AdjacencyList {
  LinkedList< Pair<Integer, Integer> >[] adjacencyList;
  
  public AdjacencyList (int vertices) {
    adjacencyList = (LinkedList<Pair<Integer, Integer> >[]) new LinkedList[vertices];
    for (int i = 0; i < adjacencyList.length; i++) {
      adjacencyList[i] = new LinkedList<Pair<Integer, Integer> >();
    }
  }
  
  // Appends a new Edge to the linked list
  public void addEdge(int startVertex, int endVertex, int weight) {
    adjacencyList[startVertex].add(new Pair<Integer, Integer>(endVertex, weight));
  }
  
  // Returns number of vertices
  // Does not change for an object
  public int getNumberOfVertices() {
    return adjacencyList.length;
  }
  
  // Returns number of outward edges from a vertex
  public int getNumberOfEdgesFromVertex(int startVertex) {
    return adjacencyList[startVertex].size();
  }
  
  // Returns a copy of the Linked List of outward edges from a vertex
  public LinkedList< Pair<Integer, Integer> > getEdgesFromVertex(int startVertex) {
    LinkedList< Pair<Integer, Integer> > edgeList
      = (LinkedList< Pair<Integer, Integer> >) new LinkedList(adjacencyList[startVertex]);
    
    return edgeList;
  }
  
  // Prints the Adjaency List
  public void printAdjacencyList() {
    char i = 'A';
    
    for (LinkedList< Pair<Integer, Integer> > list : adjacencyList) {
      System.out.print("adjacencyList[" + i + "] -> ");
      
      for (Pair<Integer, Integer> edge : list) {
        System.out.print(edge.getKey() + "(" + edge.getValue() + ") ");
      }
      
      ++i;
      System.out.println();
    }
  }
  
  // Removes an edge and returns true if there
  // was any change in the collection, else false
  public boolean removeEdge(int startVertex, Pair<Integer, Integer> edge) {
    return adjacencyList[startVertex].remove(edge);
  }
  
  
  
  //Dijkstra Algorithm++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  public void dijkstra(int s) {
    
    int[] shortestPath = new int[adjacencyList.length];
    for(int i = 0; i < shortestPath.length; i++) {
      shortestPath[i] = Integer.MAX_VALUE;
    }
    shortestPath[s] = 0;
    
    char[] S = new char[adjacencyList.length];
    int i = 0;
    for (LinkedList< Pair<Integer, Integer> > list : adjacencyList) {
      S[i] = 'W';
      i++;
    }
    S[s] = 'G';
    
    Queue<Integer> Q = new LinkedList<Integer>();
    Q.add(s);
   int min;
   
    while(Q.peek() != null) {
      int u = Q.remove();
      S[u] = 'B';
      LinkedList< Pair<Integer, Integer> > list = adjacencyList[u];
      int count = getNumberOfEdgesFromVertex(u);
      for (Pair<Integer, Integer> edge : list) {
        if(shortestPath[edge.getKey()] > shortestPath[u] + edge.getValue())
          shortestPath[edge.getKey()] = shortestPath[u] + edge.getValue();
        enqueueNextStep(S, u, Q, count);
        count--;
      }
    }
    System.out.println("Dijkstra:");
    //PRINT
    char x = 'A';
    for(int j = 0; j < 8; j++) {
      if(shortestPath[j] != Integer.MAX_VALUE)
        System.out.println("Shortest Path from A to " + x + " is " + shortestPath[j]);
      else
        System.out.println("No Path exists from A to " + x);
      x++;
    }
  }
  //Dijkstra End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
  private void enqueueNextStep(char[] S, int u, Queue<Integer> Q, int count) {
    while(count > 0) {
    int min = Integer.MAX_VALUE;
    int pos = -1;
    for (Pair<Integer, Integer> edge : adjacencyList[u]) {
      if(edge.getValue() < min && S[edge.getKey()] != 'G') {
        pos = edge.getKey();
        min = edge.getValue();
      }
    }
    if(pos >= 0 && pos < 8) {
      Q.add(pos);
      S[pos] = 'G';
    }
    count--;
    }
  }
  
  
  //Bellman-Ford Algorithm+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  public void bellmanFord(int s) {
    boolean solution = true;
    int[] shortestPath = new int[adjacencyList.length];
    for(int i = 0; i < shortestPath.length; i++) {
      shortestPath[i] = Integer.MAX_VALUE;
    }
    shortestPath[s] = 0;
    
    for(int i = 0; i < adjacencyList.length; i++){
      
      char[] S = new char[adjacencyList.length];
      int j = 0;
      for (LinkedList< Pair<Integer, Integer> > list : adjacencyList) {
        S[j] = 'W';
        j++;
      }
      S[s] = 'G';
      
      Queue<Integer> Q = new LinkedList<Integer>();
      Q.add(s);
      int min;
      
      while(Q.peek() != null) {
        int u = Q.remove();
        S[u] = 'B';
        LinkedList< Pair<Integer, Integer> > list = adjacencyList[u];
        int count = getNumberOfEdgesFromVertex(u);
        for (Pair<Integer, Integer> edge : list) {
          if(shortestPath[edge.getKey()] > shortestPath[u] + edge.getValue())
            shortestPath[edge.getKey()] = shortestPath[u] + edge.getValue();
          enqueueNextStep2(S, u, Q, count);
          count--;
        }
      }
    }
    
    for(int i = 0; i < adjacencyList.length; i++) {
      LinkedList< Pair<Integer, Integer> > list2 = adjacencyList[i];
      for(Pair<Integer, Integer> edge : list2) {
        if(shortestPath[edge.getKey()] > shortestPath[i] + edge.getValue())
            solution = false;
      }
    }
    if(solution == true) {
          System.out.println("Bellman-Ford:");
    //PRINT
    char x = 'A';
    for(int j = 0; j < 8; j++) {
      if(shortestPath[j] != Integer.MAX_VALUE)
        System.out.println("Shortest Path from A to " + x + " is " + shortestPath[j]);
      else
        System.out.println("No Path exists from A to " + x);
      x++;
    }
    }
    else 
      System.out.println("no solution for this Graph");
    
  }
  
  private void enqueueNextStep2(char[] S, int u, Queue<Integer> Q, int count) {
    while(count > 0) {
      int min = Integer.MAX_VALUE;
      int pos = -1;
      for (Pair<Integer, Integer> edge : adjacencyList[u]) {
        if(edge.getValue() < min) {
          pos = edge.getKey();
          min = edge.getValue();
        }
      }
      if(pos >= 0 && pos < 8) {
        Q.add(pos);
        S[pos] = 'G';
      }
      count--;
    }
  }
  
}
