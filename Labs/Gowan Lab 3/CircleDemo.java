/*Lab3, Exercise 1 (CircleTest), CSCI 1101
CircleTest.java creates two circle objects and a point object, and tells the user
if the p1 is within c1, touching c1, or outside c1. It also tells the user if
c1 can contain c2.
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/
public class CircleDemo{
   public static void main(String[] args){
      //creates two circle objects
      Circle c1 = new Circle(5, 5, 5);
      Circle c2 = new Circle(4, 4, 10);
      //creates point object
      Point p1 = new Point(5,10);
      System.out.println("The area of c1 is: " + c1.getArea());
      System.out.println("The circumference of c1 is: " + c1.getPerimeter());
      if(c1.contains(p1))
         System.out.println("c1 can contain p1.");
      else
         System.out.println("c1 cannot contain p1.");
      if(c1.touches(p1))
         System.out.println("p1 is touching c1's circumference.");
      else
         System.out.println("p1 is not touching c1's circumference.");
      if(c1.contains(c2))
         System.out.print("c1 can contain c2.");
      else
         System.out.print("c1 cannot contain c2.");
   }
}