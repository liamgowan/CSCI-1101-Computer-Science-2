/*Lab2 Exercise 1 Demo, CSCI 1101
PointDemo.java creates four Point objects. 
It determines which point of these four is the lowest (using the y value), and the length
between point 1 and point 2, and the length between point 3 and point 4.
June 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

import java.util.Scanner;
public class PointDemo{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      int x, y;
      //The following creates 4 Point objects, and sets user defined x and y coordinates
      System.out.print("Enter the x and y coordinates for point 1: ");
      x = input.nextInt();
      y = input.nextInt();
      Point p1 = new Point(x, y);
      System.out.print("Enter the x and y coordinates for point 2: ");
      x = input.nextInt();
      y = input.nextInt();
      Point p2 = new Point(x, y);
      System.out.print("Enter the x and y coordinates for point 3: ");
      x = input.nextInt();
      y = input.nextInt();
      Point p3 = new Point(x, y);
      System.out.print("Enter the x and y coordinates for point 4: ");
      x = input.nextInt();
      y = input.nextInt();
      Point p4 = new Point(x, y);
      //The following determines and displays the lowest point
      if(p1.isLower(p2) && p1.isLower(p3) && p1.isLower(p4))
         System.out.print("[" + p1.getXCoord() + ", " + p1.getYCoord() + "]");
         
      else if(p2.isLower(p1) && p2.isLower(p3) && p2.isLower(p4))
         System.out.print("[" + p2.getXCoord() + ", " + p2.getYCoord() + "]");
      
      else if(p3.isLower(p1) && p3.isLower(p2) && p3.isLower(p4))
         System.out.print("[" + p3.getXCoord() + ", " + p3.getYCoord() + "]");
         
      else
         System.out.print("[" + p4.getXCoord() + ", " + p4.getYCoord() + "]");
      System.out.println(" is the lowest point");
      //displays length between point 1 and point 2
      System.out.println("The length between " + "[" + p1.getXCoord() + ", " + p1.getYCoord() + "] and " +
      "[" + p2.getXCoord() + ", " + p2.getYCoord() + "] is " + p1.findLength(p2));
      //displays length between point 3 and point 4
      System.out.println("The length between " + "[" + p3.getXCoord() + ", " + p3.getYCoord() + "] and " +
      "[" + p4.getXCoord() + ", " + p4.getYCoord() + "] is " + p3.findLength(p4));
      //determines and displays whether the distance between point 1 and point 2
      //is greater than point 3 and point 4 or vice versa
      if(p1.findLength(p2)>p3.findLength(p4)){
         System.out.print("Line from [" + p1.getXCoord() + ", " + p1.getYCoord() + "] to " +
         "[" + p2.getXCoord() + ", " + p2.getYCoord() + "] is longer");
      }
      else{
      System.out.print("Line from [" + p3.getXCoord() + ", " + p3.getYCoord() + "] to " +
         "[" + p4.getXCoord() + ", " + p4.getYCoord() + "] is longer");
      }
   }
}