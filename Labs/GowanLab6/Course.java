/*Lab 6, Exercise 1 (Course), CSCI 1101
Course.java is an abstract class that contains instance variables containing information
about the name of a course, an instructor and a finalGrade. It has accessor and mutator 
methods for all of it's instance variables. It has an abstract method called 
calculateFinalGrade. It also has a toString method.
July 10, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public abstract class Course{
   //variables
   private String courseName;
   private String instructor;
   private double finalGrade;
   //mutator methods
   public void setName(String n){//sets name
      courseName = n;
   }
   public void setFinalGrade(double g){//sets course final
      finalGrade = g;
   }
   public void setInstructor(String instr){//sets instructor
      instructor = instr;
   }
   //accessor methods
   public String getName(){//returns name
      return courseName;
   }
   public double getFinalGrade(){//returns final grade
      return finalGrade;
   }
   public String getInstructor(){//returns instructor
      return instructor;
   }
   //abstract method
   public abstract void calculateFinalGrade();
   public String toString(){//displays course name, instructor and finalGrade
      String show = "";
      show += "\nCourse name: " + courseName;
      show += "\nInstructor " + instructor;
      show += "\nAverage Final Grade: " + finalGrade;
      return show;
   }
}