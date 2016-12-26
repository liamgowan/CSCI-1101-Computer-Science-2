/*Lab2 Exercise 1, CSCI 1101
Point.java has two instance variables, xCoord and yCoord. It contains methods to create
a Point object, to access and mutate variables, to determine if one point is lower than
another, and to find the length between 'this' point, and a point from another object.
June 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

public class Point{
   //instance variables
   private int xCoord;
   private int yCoord;
   
   //constructor
   public Point(int x, int y){//creates Point object, sets xCoord and yCoord
      xCoord = x;
      yCoord = y;
   }
   
   //accessors
   public int getXCoord(){//returns xCoord
      return xCoord;
   }
   public int getYCoord(){//returns yCoord
      return yCoord;
   }
   
   //mutators 
   public void setXCoord(int x){//sets xCoord
      xCoord = x;
   }
   
   public void setYCoord(int y){//sets yCoord
      yCoord = y;
   }
   
   //other methods
   public boolean isLower(Point otherPoint){
      //determines if one point is lower than another
      if(this.yCoord<otherPoint.getYCoord()){
         return true;
      }
      
      else
         return false;
   }
   
   public double findLength(Point otherPoint){
      //finds the length between 'this' point, and 'otherPoint'
      return Math.sqrt((Math.pow(otherPoint.getXCoord() - xCoord, 2)) 
      + (Math.pow(otherPoint.getYCoord() - yCoord, 2)));
   } 
}