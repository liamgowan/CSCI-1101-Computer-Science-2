/*Lab3, Exercise 1 (PointDemo), CSCI 1101
PointDemo.java creates two point objects, and finds the distance between them.
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/
public class PointDemo{
   public static void main(String[] args){
      //creates two point objects
      Point p1 = new Point(5, 2);
      Point p2 = new Point(1, -5);
      System.out.print("Distance is: " + p1.distanceFrom(p2));//displays distance between points
   }
}