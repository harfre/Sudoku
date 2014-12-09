import java.util.*;
public class SudokuMain{
  public static void main(String[] args){
    Scanner user_input = new Scanner( System.in );
    Sudoku s = new Sudoku();
    int choice;
    boolean continue = true;
    
    while(boolContinue){
      Systen.out.println("What do you whant to do?\n1: Input complete sudoku.
        \n2: Add an entry to existing sudoku.\n3: Solve existing sudoku. \n4: Show existing sudoku. \n5: Exit");
      choice = user_input.nextInt();
      switch (choice){
        case 1: //Input complete sudoku
          //Read sudoku
          //loop over sudoku, change values
          break;
        case 2: //Input single value
          //Read row
          //Read column
          //Read value
          //Change
          break;
        case 3: //Solve
          s.Solve
          break;
        case 4: //Show
          s.Print
          break;
        default: //Exit
          boolContinue = false;
          break;
      }
    }
  }
}
        
    
