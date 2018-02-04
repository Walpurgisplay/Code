class mazeNode {
  private int row;
  private int column;
  
  public mazeNode(int row, int column) {
    this.row = row;
    this.column = column;
  }
  
  public mazeNode() {
    row = 0;
    column = 0;
  }
  
  public String print() {
    return "(" + row + ", " + column + ")";
  }
  
  public boolean equals(mazeNode other) {
    if (row == other.row && column == other.column)
      return true;
    else
      return false;
  }
  
  public int getRow () {
    return row;
  }
    
  public int getColumn () {
    return column;
  }
}