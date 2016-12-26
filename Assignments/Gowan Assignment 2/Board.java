/*Assignment 2, Exercise 1 (Board), CSCI 1101
Board.java has instance variables to hold the number of rows and number of columns. It has a constructor
to make a board object, and get and set methods for the instance variables.
July 7, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Board{
   //instance variables
   private int rows;
   private int cols;
   //constructor
   public Board(int r, int c){//makes board object
      rows = r;//initializes rows
      cols =r;//initializes cols
   }
   //accessor methods
   public int getRows(){//returns rows
      return rows;
   }
   public int getCols(){//returns cols
      return cols;
   }
   //mutator methods
   public void setRows(int r){
      rows = r;//sets rows
   }
   public void setCols(int c){
      cols = c;//sets cols
   }
}