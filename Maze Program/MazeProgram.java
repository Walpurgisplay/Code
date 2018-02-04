//==============================================================
//    Maze Program
//==============================================================
// James Ream
// 2/28/17

import java.util.*;
import java.io.*;

public class MazeProgram {
  
  public static void main(String[] args) throws FileNotFoundException{
    //INITIALIZATION
    File input = new File("maze.txt");
    Scanner console = new Scanner(System.in);
    Scanner read = new Scanner(input);
    char[][] maze;
    char [][] pathMaze;
    int entranceR = 0;
    int entranceC = 0;
    
    
    
    maze = new char[30][20];
    pathMaze = new char[30][20];
    String line = "";
    
    //CREATING MAZE
    for (int i = 0; i < 30; i++) {
      line = read.next();
      for (int j = 0; j < 20; j++) {
        maze[i][j] = line.charAt(j);
      }
    }
    
    boolean pathFound = false;
    boolean validInput = false;
    
    //WHILE LOOP FOR FINDING PATH----------------
    while (pathFound == false) {
      printMaze(maze);
      while (validInput == false) {
        
      //INPUT VALIDATION
      System.out.println("enter entrance row(0-29)");
      entranceR = console.nextInt();
      System.out.println("enter entrance column(0-19)");
      entranceC = console.nextInt();
      if (entranceR < 0 || entranceC < 0 || entranceR > 29 || entranceC > 19)
        System.out.println("error entrance not within bounds of maze");
      else if (maze[entranceR][entranceC] == '1') 
        System.out.println("Error, cannot start at a location with 1, try again");
      else if (maze[entranceR][entranceC] == 'E')
        System.out.println("Error, cannot start at entrance, try again");
      else
        validInput = true;
      }
      
      //CREATE PATH MAZE
      for (int i = 0; i < 30; i++) {
        for (int j = 0; j < 20; j++) {
          pathMaze[i][j] = maze[i][j];
        }
      }
      pathMaze[entranceR][entranceC] = 'S';
      
      //CALL FIND PATH---
      if (pathFound == false) {
        if (findPath(pathMaze, entranceR, entranceC)) {
          pathFound = true;
          System.out.println("I AM FREE!");
          printMaze(pathMaze);
        }
        else {
          System.out.println("HELP, I AM TRAPPED!\n");
          validInput = false;
        }
      }//END FIND PATH LOOP---
    }//END MAZE WHILE LOOP ------------
    
    

    
    
    read.close();
    console.close();
  }
  
  
  //==========================================
  //END OF MAIN--------------------------------
  //===========================================
  
  
  //PRINT INITIAL MAZE-------------------------
  public static void printMaze(char[][] maze) {
    System.out.print("   ");
    for (int k = 0; k < 20; k++)
      System.out.printf("%3d", k);
    System.out.println("\n");
    for (int i = 0; i < 30; i++) {
      System.out.printf("%3d", i);
      for (int j = 0; j < 20; j++) {
        System.out.printf("%3s", maze[i][j]);
      }
      System.out.println();
    }
  }
  
  //-----------------------------
  //FIND PATH WITH GIVEN ENTRANCE------------------------
  //-----------------------------
  public static boolean findPath(char[][] maze, int R, int C) {
    
    //EXIT FOUND
    if (maze[R][C] == 'E')
      return true;
    
     //WEST
    if(C-1 >= 0 && C-1 <= 19 && maze[R][C-1] != '+') { //TEST IF OUT OF BOUNDS
      if (maze[R][C-1] != '1' ) { //TEST IF WALL AHEAD
        if (maze[R][C-1] == 'E')
          return true;
        maze[R][C-1] = '+';
        if (findPath(maze, R, C-1))
          return true;
        maze[R][C-1] = '0';
      }
    }
    
    //NORTH
    if(R-1 >= 0 && R-1 <= 29 && maze[R-1][C] != '+') { //TEST IF OUT OF BOUNDS
      if (maze[R-1][C] != '1' ) { //TEST IF WALL AHEAD
        if (maze[R-1][C] == 'E')
          return true;
        maze[R-1][C] = '+';
        if (findPath(maze, R-1, C))
          return true;
        maze[R-1][C] = '0';
      }
    }
    
    //EAST
    if(C+1 >= 0 && C+1 <= 19 && maze[R][C+1] != '+') { //TEST IF OUT OF BOUNDS
      if (maze[R][C+1] != '1' ) { //TEST IF WALL AHEAD
        if (maze[R][C+1] == 'E')
          return true;
        maze[R][C+1] = '+';
        if (findPath(maze, R, C+1))
          return true;
        maze[R][C+1] = '0';
      }
    }
    
    //SOUTH
    if(R+1 >= 0 && R+1 <= 29 && maze[R+1][C] != '+') { //TEST IF OUT OF BOUNDS
      if (maze[R+1][C] != '1') { //TEST IF WALL AHEAD
        if (maze[R+1][C] == 'E')
          return true;
        maze[R+1][C] = '+';
        if (findPath(maze, R+1, C))
          return true;
        maze[R+1][C] = '0';
      }
    }
    
   
    //PATH NOT FOUND
    return false;
  }
}
//END OF PROGRAM===================================================================

