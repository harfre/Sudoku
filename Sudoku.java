public class Sudoku{
  int[][] val;
  
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
  
  public Sudoku solve(){
    int[][] solvedVal = recursiveStep(val, 0, 0);
    if(solvedVal[0][0]==0){
      System.out.println("Sudoku not solvable:");
      print();
    }else{
      val=solvedVal;
      print();
    }
    return new Sudoku(solvedVal);
  }
  
  private static int[][] recursiveStep(int[][] inputSudoku, int iPos){
    int iRow = iPos/9;
    int iCol = iPos%9;
    int[][] outputSudoku;
    
    System.out.println("\nRow: " + iRow + "\nCol: " + iCol + "\nCurrent Value:" + inputSudoku[iRow][iCol]);  
    if(isWrong(inputSudoku, iRow, iCol)){
      System.out.println("Not accepted");
      if(inputSudoku[iRow][iCol]==9){
        return new int[9][9];
      }else{
        inputSudoku[iRow][iCol]++;
      }
    }else{
      System.out.println("Accepted");
      iPos++;
      if(iPos==81){
        return inputSudoku;
      }
    }
    outputSudoku = recursiveStep(inputSudoku, iPos);
    outputSudoku
  }
  private static boolean isWrong(int[][] s, int iRow, int iCol){
    int testVal = s[iRow][iCol];
    for (int j=0;j<9;j++){
      if ((testVal == s[j][iCol])&&j!=iRow){
        System.out.println("Column error");
        return true;
      }
    }
    for (int j=0;j<9;j++){
      if ((testVal == s[iRow][j])&&j!=iCol){
        System.out.println("Row error");
        return true;
      }
    }
    for (int j=0;j<9;j++){
      int relRow =iRow%3;
      int relCol = iCol%3;
      int boxRow = iRow/3;
      int boxCol = iCol/3;
      int jRow = j/3;
      int jCol = j%3;
      if ((testVal == s[boxRow*3+jRow][boxCol*3+jCol]) && (jRow!=relRow || jCol != relCol)){
        System.out.println("Box error, j = " + j);
        return true;
      }
    }
    return false;
  }
  
}
