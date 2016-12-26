/*Lab2 Exercise 2, CSCI 1101
Rectangle2D.java has instance variables for xpos, ypos, width and height of a rectangle.
It contains methods to create objects, access and mutate the variables, to determine if a 
point could fit inside the rectangle object, and whether or not another rectangle could fit
inside 'this' rectangle.
June 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

public class Rectangle2D{
   //instance variables
   private double xpos;
   private double ypos;
   private double width;
   private double height;
   
   //constructor
   public Rectangle2D(){//creates object, sets xpos and ypos
      xpos = 0.0;
      ypos = 0.0;
   }
   
   public Rectangle2D(double xpos, double ypos, double width, double height ){
      //creates object, sets xpos, ypos, width and height
      this.xpos = xpos;
      this.ypos = ypos;
      this.width = width;
      this.height = height;
   }
   
   //accessor methods
   public double getXPos(){//returns x position
      return xpos;
   }
   public double getYPos(){//returns y position
      return ypos;
   }
   public double getWidth(){//returns width
      return width;
   }
   public double getHeight(){//returns height
      return height;
   }
   
   //mutator methods
   
   public void setXPOS(double xpos){//sets x position
      this.xpos = xpos;
   }
   public void setYPOS(double ypos){//sets y position
      this.ypos = ypos;
   }
   public void setWidth(double width){//sets width
      this.width = width;
   }
   public void setHeight(double height){//sets height
      this.height = ypos;
   }
   
   //other methods
   public double getArea(){//returns area
      return height * width;
   }
   public double getPerimeter(){//returns perimeter
      return 2 * height + 2 * width;
   }
   
   public boolean contains(double x, double y){//determines if a point is in a rectangle
      //The point's x position must be greater than or equal to the left side of rectangle
      //which is the same as xpos, and less than or equal to the right side of rectangle, which 
      //is the same as xpos + width.
      //The point's y position must be less than or equal to the top side of rectangle
      //which is the same as ypos, and greater than or equal to the bottom side of triangle, which 
      //is the same as ypos - height
      if(x <= xpos + width && x >= xpos && y >= ypos - height && y <= ypos)
         return true;
      return false;
   }
   
   public boolean contains(Rectangle2D r){
      //This method determines whether or not a rectangle can fit inside of another.
      //It does that by determining what the coordinates of the corners of 'r' would be.
      double topRightCornerY = r.getYPos();
      double topRightCornerX = r.getWidth() + r.getXPos();
      double bottomRightCornerY = r.getYPos() - r.getHeight();
      double bottomRightCornerX = topRightCornerX;
      double bottomLeftCornerY = bottomRightCornerY;
      double bottomLeftCornerX = r.getXPos();
      
      //using the contains() method, it then determines if the coordinates for each corner
      //would fit inside the rectangle.
      //It makes sense that if all four corners of 'r' can fit inside 'this' rectangle,
      //then r can.
      //The first if statement determines if the top left corner of r would fit inside 'this'
      //rectangle. The others determine it for every other corner.
       
      if(contains(r.getXPos(), r.getYPos()))
         if(contains(topRightCornerX, topRightCornerY))
            if(contains(bottomRightCornerX, bottomRightCornerY))
               if(contains(bottomLeftCornerX, bottomLeftCornerY))
                  return true;
      return false;
   }
   
}
   