/*Lab1, Part 2, Exercise 1, CSCI 1101
Circle.java holds will hold information about a circle, can create a circle,
and contains methods to calculate the area and circumference about the circle
June 22, 2015
Liam Gowan B00673126
This is entirely my own work
*/
public class Circle{
   //Instance variables
   private double PI = 3.14159;
   private double radius;
   private String colour;
   
   //Methods
   public Circle (double radius, String colour) {//creates Circle object, assigns radius and colour from args
      this.radius = radius;
      this.colour = colour;
   }
   
   //get methods (Accessor Methods)
   public double getRadius(){//will return the radius
      return radius;
   }
   
   public String getColour(){//will return the colour
      return colour;
   }
   
   
   //set methods (Mutator methods)
   public void setRadius(double r){//will set the radius
      this.radius = r;
   }
   
   public void setColour(String c){//will set the colour
      colour = c;
   }
   
   public double findArea(){ //will calculate and return the area
      return PI * radius * radius;
   }
   
   public double findCircumference(){//will calculate and return the circumference
      return 2 * PI * radius;
   }
   public String toString(){//will print radius, area and colour
      return "Radius: " + getRadius() + "\tArea: " + findArea() + "\tColour: " + getColour();
   }
}
  
  
   