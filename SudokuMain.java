import java.util.*;
public class SudokuMain{
  public static void main(String[] args){
    Scanner user_input = new Scanner( System.in );
    Sudoku s = new Sudoku();
    int choice;
    int iRow, iCol, newVal;
    boolean boolContinue = true;
    
    while(boolContinue){
      System.out.println("What do you whant to do?\n1: Input complete sudoku.\n2: Add an entry to existing sudoku.\n3: Solve existing sudoku. \n4: Show existing sudoku. \n5: Exit");
      choice = user_input.nextInt();
      switch (choice){
        case 1: //Input complete sudoku
          System.out.print("\nOops, not supported yet.\n");
          //Read sudoku
          //loop over sudoku, change values
          break;
        case 2: //Input single value
          //Add protection for bad values!
          System.out.print("\nRow (1-9): ");           
          iRow =  user_input.nextInt() - 1;
          System.out.print("\nColumn (1-9): ");
          iCol =  user_input.nextInt() - 1;
          System.out.print("\nValue (1-9): ");
          newVal =  user_input.nextInt();
          s.changeVal(iRow,iCol,newVal);
          break;
        case 3: //Solve
          s.solve();
          break;
        case 4: //Show
          s.print();
          break;
        default: //Exit
          boolContinue = false;
          break;
      }
    }
  }
}
