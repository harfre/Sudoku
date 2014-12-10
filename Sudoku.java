public class Sudoku{
  private int[][] val;
  
  public Sudoku(){
    val = new int[9][9];
    for (int iRow = 0; iRow<9; iRow++){
      for(int iCol = 0; iCol<9; iCol++){
        val[iRow][iCol]=0;
      }
    }
  }
  public Sudoku(int[][] sudokuMatrix){
    val = sudokuMatrix;
  }
  
  public Sudoku(int[] sudokuVector){
    val = new int[9][9];
    if (sudokuVector.length>81){
      System.out.println("Input vector too long: " + sudokuVector.length);
    }else{
      for (int iRow = 0; iRow<9; iRow++){
        for(int iCol = 0; iCol<9; iCol++){
          if(iRow+9*iCol<sudokuVector.length){
            val[iRow][iCol]=sudokuVector[iRow+9*iCol];
          }else{
            break;
          }
        }
      }
    }
  }
  public void changeVal(int iRow, int iCol, int newVal){
    val[iRow][iCol]=newVal;
  }
  public void print(){
    for (int iRow = 0; iRow<9; iRow++){
      for(int iCol = 0; iCol<9; iCol++){
        System.out.print(val[iRow][iCol] + " ");
        if(iCol == 2 || iCol == 5){
          System.out.print("| ");
        }
      }
      System.out.println();
      if(iRow == 2 || iRow == 5){
        System.out.println("---------------------");
      }
    }
    System.out.println();
  }
  
  public void solve(){
    if(recursiveStep(0)){
      print();
    }else{
      System.out.println("Sudoku not solvable:");
      print();
    }
  }
  
  private boolean recursiveStep(int iPos){
    int iRow = iPos/9;
    int iCol = iPos%9;
    
    if(iPos == 81)
      return true;
    if(val[iRow][iCol]!=0){
      if(recursiveStep(iPos+1)){
        return true;
      }
    }else{
      for (int j=1;j<=9;j++){
        val[iRow][iCol] = j;
        if(isOK(iRow, iCol)){
          if(recursiveStep(iPos+1)){
            return true;
          }else{
            val[iRow][iCol] = 0;
          }
        }else{
          val[iRow][iCol] = 0;
        }
      }
    }
    return false;
  }
  
  private boolean isOK(int iRow, int iCol){
    int testVal = val[iRow][iCol];
    for (int j=0;j<9;j++){
      if ((testVal == val[j][iCol])&&j!=iRow){
        return false;
      }
    }
    for (int j=0;j<9;j++){
      if ((testVal == val[iRow][j])&&j!=iCol){
        return false;
      }
    }
    for (int j=0;j<9;j++){
      int relRow = iRow%3;
      int relCol = iCol%3;
      int boxRow = iRow/3;
      int boxCol = iCol/3;
      int jRow = j/3;
      int jCol = j%3;
      if ((testVal == val[boxRow*3+jRow][boxCol*3+jCol]) && (jRow!=relRow || jCol != relCol)){
        return false;
      }
    }
    return true;
  }
  public void reset(){
    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        val[i][j]=0;
      }
    }
  }
}
