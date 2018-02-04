  //==============================================================
  //    Program 3 – Tree Implementations
  //==============================================================
  // James Ream
  // 336.001
  // 4/27/17


import java.util.*;
import java.lang.*;

public class TreeImplementations {
  public static void main(String[] args) {
    
    long startTime;
    long stopTime;
    
    
    //startTime = System.currentTimeMillis();
    
    //stopTime = System.currentTimeMillis();
    
    
    
    BinaryTree tree = new BinaryTree();
    
    for (int i = 26; i > 0; i--)
      tree.insert(i);
    
    System.out.println("Tree 1:");
    System.out.println("Depth First Traversal(LNR)");
    startTime = System.currentTimeMillis();
    tree.depthFirstTraversal();
    stopTime = System.currentTimeMillis();
    
    System.out.println("\nElapsed time = "+(stopTime-startTime)+" msecs.");
    System.out.println("\nBreadth First Traversal");
    startTime = System.currentTimeMillis();
    tree.breadthFirstTraversal();
    stopTime = System.currentTimeMillis();
    System.out.println("\nElapsed time = "+(stopTime-startTime)+" msecs.");
    
    System.out.println("\n\nBest First Traversal");
    startTime = System.currentTimeMillis();
    tree.bestFirstTraversal();
    stopTime = System.currentTimeMillis();
    System.out.println("\nElapsed time = "+(stopTime-startTime)+" msecs.");
    System.out.println();
    
    BinaryTree tree2 = tree.balance(26);
    System.out.println("\n\nTree 2(balanced):");
    
    System.out.println("Depth First Traversal(LNR)");
    startTime = System.currentTimeMillis();
    tree2.depthFirstTraversal();
    stopTime = System.currentTimeMillis();
    System.out.println("\nElapsed time = "+(stopTime-startTime)+" msecs.");
    
    System.out.println("\nBreadth First Traversal");
    startTime = System.currentTimeMillis();
    tree2.breadthFirstTraversal();
    stopTime = System.currentTimeMillis();
    System.out.println("\nElapsed time = "+(stopTime-startTime)+" msecs.");
    
    System.out.println("\n\nBest First Traversal");
    startTime = System.currentTimeMillis();
    tree2.bestFirstTraversal();
    stopTime = System.currentTimeMillis();
    System.out.println("\nElapsed time = "+(stopTime-startTime)+" msecs.");
  }
  
}