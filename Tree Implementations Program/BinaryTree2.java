public class BinaryTree2 {
  
  Node root;
  
  public void addNode(int key, String name) {
    // Create a new Node and initialize it
    Node newNode = new Node(key, name);
    // If there is no root this becomes root
    if (root == null) {
      root = newNode;
    } else {
      // Set root as the Node we will start
      // with as we traverse the tree
      Node focusNode = root;
      // Future parent for our new Node
      Node parent;
      while (true) {
        // root is the top parent so we start
        // there
        parent = focusNode;
        // Check if the new node should go on
        // the left side of the parent node
        if (key < focusNode.key) {
          // Switch focus to the left child
          focusNode = focusNode.leftChild;
          // If the left child has no children
          if (focusNode == null) {
            // then place the new node on the left of it
            parent.leftChild = newNode;
            return; // All Done
          }
        } else { // If we get here put the node on the right
          focusNode = focusNode.rightChild;
          // If the right child has no children
          if (focusNode == null) {
            // then place the new node on the right of it
            parent.rightChild = newNode;
            return; // All Done
          }
        }
      }
    }
  }
  
  // All nodes are visited in ascending order
  // Recursion is used to go to one node and
  // then go to its child nodes and so forth
  
  public void inOrderTraverseTree(Node focusNode) {
    
    if (focusNode != null) {
      
      // Traverse the left node
      
      inOrderTraverseTree(focusNode.leftChild);
      
      // Visit the currently focused on node
      
      System.out.println(focusNode);
      
      // Traverse the right node
      
      inOrderTraverseTree(focusNode.rightChild);
      
    }
    
  }
  //================================================================================
  public void balance(BinaryTree2 tree, int[] array, int x, int b, int t) {
    readArray(tree.root, array, x);
    
    balanceBuild(b, t, array);
  }
  
  
  public void readArray2(int[] array, int x) {
    readArray(root, array, x);
  }
  
  public void readArray(Node focusNode, int[] array, int x) {
    
    if (focusNode != null) {
      
      inOrderTraverseTree(focusNode.leftChild);
      
      array[x] = focusNode.key;
      
      inOrderTraverseTree(focusNode.rightChild);
      
    }
    
  }
  
  public void balanceBuild(int b, int t, int[] array) {
    int mid = (t-b-1)/2;
    
    if (t>b) {
      addNode(array[mid], "B");
      balanceBuild(b, mid-1, array);
      balanceBuild(mid+1, t, array);
    }
  }
    
    
    
    
  public void preorderTraverseTree(Node focusNode) {
    
    if (focusNode != null) {
      
      System.out.println(focusNode);
      
      preorderTraverseTree(focusNode.leftChild);
      preorderTraverseTree(focusNode.rightChild);
      
    }
    
  }
  
  public void postOrderTraverseTree(Node focusNode) {
    
    if (focusNode != null) {
      
      postOrderTraverseTree(focusNode.leftChild);
      postOrderTraverseTree(focusNode.rightChild);
      
      System.out.println(focusNode);
      
    }
    
  }
  
  public Node findNode(int key) {
    
    // Start at the top of the tree
    
    Node focusNode = root;
    
    // While we haven't found the Node
    // keep looking
    
    while (focusNode.key != key) {
      
      // If we should search to the left
      
      if (key < focusNode.key) {
        
        // Shift the focus Node to the left child
        
        focusNode = focusNode.leftChild;
        
      } else {
        
        // Shift the focus Node to the right child
        
        focusNode = focusNode.rightChild;
        
      }
      
      // The node wasn't found
      
      if (focusNode == null)
        return null;
      
    }
    
    return focusNode;
    
  }
  //MAIN==============================================================
  //==================================================================
  public static void main(String[] args) {
    
    BinaryTree2 theTree = new BinaryTree2();
    for (int i = 0; i < 26; i++)
      theTree.addNode(i, "B");
    theTree.inOrderTraverseTree(theTree.root);
    int[] array = new int[26];
    BinaryTree2 secondTree = new BinaryTree2();
    int x = 0;
    int b = 0;
    int t = 26;
    secondTree.balance(theTree, array, x, b, t);
    // Different ways to traverse binary trees
    
    // theTree.inOrderTraverseTree(theTree.root);
    
    // theTree.preorderTraverseTree(theTree.root);
    
    // theTree.postOrderTraverseTree(theTree.root);
    
    // Find the node with key 75
    
    //System.out.println("\nNode with the key 75");
    
    //System.out.println(theTree.findNode(75));
    
  }
}

class Node {
  
  int key;
  String name;
  
  Node leftChild;
  Node rightChild;
  
  Node(int key, String name) {
    
    this.key = key;
    this.name = name;
    
  }
  
  public String toString() {
    
    return name + " has the key " + key;
    
    /*
     * return name + " has the key " + key + "\nLeft Child: " + leftChild +
     * "\nRight Child: " + rightChild + "\n";
     */
    
  }
  
}
