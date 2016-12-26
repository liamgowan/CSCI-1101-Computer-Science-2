/*Lab2 Exercise 2 Demo, CSCI 1101
Rectangle2DDemo.java creates two Rectangle2DObjects and sets xpos, ypos, width and height of a rectangle.
It determines and displays if one rectangle can fit inside of another.
June 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Rectangle2DDemo{
   public static void main(String[] args){
      //creates two Rectangle2D objects, assigns xpos, ypos, width and height for each
      Rectangle2D r1 = new Rectangle2D(2, 2, 7, 8);
      Rectangle2D r2 = new Rectangle2D(2, 2, 8.3, 9);
      //determines if a point can fit inside a rectangle
      if(r1.contains(2,1))
         System.out.print("\nThis point does fit inside r1.");
      else
         System.out.print("\nThis point does not fit inside r1.");
      //determines if r2 can fit inside r1
      System.out.println("\nThe area of r1 is: " + r1.getArea());
      System.out.print("The perimeter of r1 is: " + r1.getPerimeter());
      if(r1.contains(r2))
         System.out.print("\nr2 fits inside r1.");
      else
         System.out.print("\nr2 does not fit inside r1.");
   }
}