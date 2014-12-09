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
        if sudokuVector.length>81{
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
    
    public void print(){
        for (int iRow = 0; iRow<9; iRow++){
            for(int iCol = 0; iCol<9; iCol++){
                System.out.print(val[iRow][iCol] + " ");
                if(iCol % 3 == 2){
                    System.out.print("| ");
                }
            }
            System.out.println();
            if(iRow % 3 == 2){
                System.out.println("______|_______|______");
            }
        }
        System.out.println();
    }
    
    public Sudoku solve(){
        int[][] solvedVal = recursiveStep(val, 0, 0);
        if(solvedVal[0][0]==0){
            System.out.println("Sudoku not solvable:")
        print();
        }else{
            val=solvedVal;
            print();
        }
    }
    
    private static int[][] recursiveStep(int[][] inputSudoku, int iRow, int iCol){
        if(isWrong(inputSudoku, iRow, iCol)){
            if(inputSudoku[iRow][iCol]==9){
               return new int[9][9];   
            }else{
                inputSudoku[iRow][iCol]++;
            }
        }else{
            iCol++;
            if(iCol==9){
                iCol=0;
                iRow++;
                if(iRow==9){
                    return inputSudoku;
                }
            }
        }
        return recursiveStep(inputSudoku, iRow, iCol);
    }
    
}
