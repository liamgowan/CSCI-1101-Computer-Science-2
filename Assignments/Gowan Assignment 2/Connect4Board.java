/*Assignment 2, Exercise 1 (Connect4Board), CSCI 1101
Connect4Board.java has instance variable Chip array which can hold 42 Chip objects.
It has a contructor which makes a Board object. It has an accessor method, which returns the 
colour (or "") of a Chip object depending on the point of interest. It also has a method which 
set a Chip object at a point of interest. It also has a method (add) that will add a Chip object 
using setCB() if there is room in the column. It also has a method which will check to see if there
is a winner, meaning that there are 4 Chip objects of the same colour 'connecting' in the same
row, column, diagonal or subdiagonal.
July 7, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

import java.util.Scanner;
public class Connect4Board extends Board{
   //instance variable
   private Chip board[][] = new Chip[6][7];
   //constructor
   public Connect4Board(int r, int c){//makes Connect4Board as well as Board object
      super(r, c);
   }
   //accessor method
   public String getCB(int r, int c){//returns colour of chip if it exists
      if(board[r][c] == null)
         return "";
      return board[r][c].getColour();
   }
   //mutator method
   public void setCB(int r, int c, String n){//sets colour of chip
      Chip c1 = new Chip(n);
      board[r][c] = c1;
   }
   //other methods
   public boolean add(int cols, String clr){
   //adds a new chip in selected column if there is room
      while(cols<1 || cols>7){
         System.out.print("Invalid column number. Please input a column between 1-7: ");
         Scanner input = new Scanner(System.in);
         cols = input.nextInt();
      }
      for(int i=5; i>=0; i--){
         if(board[i][cols-1] == null){
            setCB(i,cols-1, clr);
            return true;
         }  
      }
      return false;
   }
   
   public boolean winner(){
   /* This (long) method checks the entire board to see if there are 4 chips of the same colour
   that are 'connected' in rows, columns, diagonals and subdiagonals. First it checks to see if 
   there are actually four chips at the location of interest, and then it checks to see if they
   are the same colour using the equals() method in the Chip class.
   */
      //check all rows
      for(int i=0; i<6; i++){//goes through rows
         for(int j=0; j<2; j++){//goes through columns
            if(board[i][j] != null && board[i][j+1] != null && board[i][j+2] != null &&
board[i][j+3] != null)           
               if(board[i][j].equals(board[i][j+1]))
                  if(board[i][j].equals(board[i][j+2]))
                     if(board[i][j].equals(board[i][j+3])){
                        return true;
                     }
            if(board[i][j+1] != null && board[i][j+2] != null && board[i][j+3] != null &&
board[i][j+4] != null) 
               if(board[i][j+1].equals(board[i][j+2]))
                  if(board[i][j+1].equals(board[i][j+3]))
                     if(board[i][j+1].equals(board[i][j+4]))
                        return true;
            if(board[i][j+2] != null && board[i][j+3] != null && board[i][j+4] != null &&
board[i][j+5] != null)
               if(board[i][j+2].equals(board[i][j+3]))
                  if(board[i][j+2].equals(board[i][j+4]))
                     if(board[i][j+2].equals(board[i][j+5]))
                       return true;
         }
      } 
      //check all columns
      for(int j=0; j<7; j++){//goes through columns
         if(board[0][j] != null && board[1][j] != null && board[2][j] != null &&
board[3][j] != null)
            if(board[0][j].equals(board[1][j]))
               if(board[0][j].equals(board[2][j]))
                  if(board[0][j].equals(board[3][j]))
                     return true;
         if(board[1][j] != null && board[2][j] != null && board[3][j] != null &&
board[4][j] != null)
            if(board[1][j].equals(board[2][j]))
               if(board[1][j].equals(board[3][j]))
                  if(board[1][j].equals(board[4][j]))
                     return true;
         if(board[2][j] != null && board[3][j] != null && board[4][j] != null &&
board[5][j] != null) 
            if(board[2][j].equals(board[3][j]))
               if(board[2][j].equals(board[4][j]))
                  if(board[2][j].equals(board[5][j]))
                     return true;     
      }
      //check diagonals 
      for(int i=0; i<3; i++){//goes through rows
         for(int j=0; j<4; j++){//goes through columns
            if(board[i][j+3] != null && board[i+1][j+2] != null && board[i+2][j+1] != null && 
board[i+3][j] != null)
            if(board[i][j+3].equals(board[i+1][j+2]))
               if(board[i][j+3].equals(board[i+2][j+1]))
                  if(board[i][j+3].equals(board[i+3][j]))
                     return true;
         }
      }
      //checks for subdiagonals
      for(int i=0; i<3; i++){//goes through rows
         for(int j=0; j<4; j++){//goes through columns
            if(board[i][j] != null && board[i+1][j+1] != null && board[i+2][j+2] != null &&
board[i+3][j+3] != null)
               if(board[i][j].equals(board[i+1][j+1]))
                  if(board[i][j].equals(board[i+2][j+2]))
                     if(board[i][j].equals(board[i+3][j+3]))
                        return true;
         }
      }
      return false;
   }
}
   