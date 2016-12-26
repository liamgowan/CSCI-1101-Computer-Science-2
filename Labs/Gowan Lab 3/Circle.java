/*Lab3, Exercise 1 (Circle), CSCI 1101
Circle.java has a Point variable called circCentre and has a variable for the radius. 
It can create circle objects and set their circCentre's and radii. It has get and set methods
for it's variables. It has methods to tell whether or not a point is inside a circle (without 
touching it), whether or not a point is touching the circle's circumference, and whether or not 
another circle can fit inside 'this' circle.
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/

public class Circle{
   //instance variables
   private Point circCentre;
   private double radius;
   
   //no-arg constructor
   public Circle(){
   //sets circCentre to 0,0, sets radius to 1.0
      circCentre = new Point(0,0);
      radius = 1.0;
   }
   
   //constructor that specifies instance variables
   public Circle(int x, int y, double r){
   //sets circCentre to whatever x and y are, sets radius to r
      circCentre = new Point(x, y);
      radius = r;
   }
   
   //other methods
   public double getArea(){
      //returns the area of the circle
      return Math.PI * Math.pow(radius, 2);
   }
   
   public double getPerimeter(){
      //returns the perimeter of the cirlce
      return 2 * Math.PI * radius;
   }
   
   public Point getCircCentre(){
      return circCentre;
   }
   public double getRadius(){
      return radius;
   }
   
   public boolean contains(Point p){
      //checks to see if distance between circCentre and p is greater than
      //radius, if it is, it will return false. Otherwise, it will return true
      if(p.distanceFrom(circCentre)>=radius)
         return false;
      return true;
   }
   
   public boolean touches(Point p){
      //checks to see if distance between circCentre and p is equal to the
      //radius, if it is, it will return true. Otherwise, it will return false
      if(p.distanceFrom(circCentre) == radius)
         return true;
      return false;
   }
   
   public boolean contains(Circle c){
      //method first sees if the centre of circle c can even be contained in 'this' circle
      if(contains(c.getCircCentre()))
      //method then sees if 'this' radius is greater than c's radius, minus the distance
      //of c's cicrle centre to 'this' circle centre
         if(radius > (c.radius - c.circCentre.distanceFrom(circCentre)))
            return true;
      return false;
   }
   
}
   