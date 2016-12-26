/*Assignment 2, Exercise 1 (Chip), CSCI 1101
Board.java has instance variables to hold the colour of a chip. It has a contructor which makes 
a Chip object and sets it's colour. It has get and set methods for the colour variable. It also has
a toString method which prints the colour.
July 7, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

public class Chip{
   //instance variable
   private String colour;
   //constructor
   public Chip(String c){
      colour = "" + c.toUpperCase().charAt(0);//initializes colour
   }
   //accessor method
   public String getColour(){//returns colour
      return colour;
   }
   //mutator method
   public void setColour(String c){
      colour = "" + c.toUpperCase().charAt(0);//sets colour
   }
   //other methods
   public boolean equals(Chip c){//tests to if this Chip object has the same colour as another
      if(colour.equals(c.getColour()))
         return true;
      return false;
   }
   
   public String toString(){
      return colour; //returns colour
   } 
}