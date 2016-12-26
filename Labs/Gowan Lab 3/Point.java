/*Lab3, Exercise 1 (Point), CSCI 1101
Point.java has variables for the x and y coordinates of a point, can create a point object.
It has methods to get and set the x and y coordinates. It has a method to find the distance 
between 'this' point object and another point object.
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/

public class Point{
   //instance variables
   private int xCoord;
   private int yCoord;
   
   //constructor
   public Point(int x, int y){
      //creates Point object, sets xCoord and yCoord
      xCoord = x;
      yCoord = y;
   }
   
   //accessor methods
   public int getXCoord(){//returns xCoord
      return xCoord;
   }
   public int getYCoord(){//returns yCoord
      return yCoord;
   }
   
   //mutator methods
   public void setXCoord(int x){//sets xCoord
      xCoord = x;
   }
   public void setYCoord(int y){//sets yCoord
      yCoord = y;
   }
   
   //other methods
   public double distanceFrom(Point another){
      return Math.sqrt(Math.pow(xCoord - another.getXCoord(), 2) + 
Math.pow(yCoord - another.getYCoord(), 2));
   } 
   
}