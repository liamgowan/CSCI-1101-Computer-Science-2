/* Lab 5, Exercise 2 (HighSchool), CSCI 1101
HighSchool.java has instance variables for the number of teachers and name of the principal.
It also has a constructor that sets the name of a School object, the num of students of a School
object, the name of the principal and the number of teachers. It has get and set methods. It has
a method to calculate the ratio of students to teachers as well as a toString method which
prints information about the HighSchool object. 
July 6, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class HighSchool extends School{
   //instance variables
   private String principal;
   private int numTeachers;
   //constructor
   public HighSchool(String name, int numS, String p, int numT){
      //creates school object and sets the students in that school, sets principal name
      //and numTeachers
      super(name);
      super.setNumStudents(numS);
      principal = p;
      numTeachers = numT;
   }
   //accessors methods
   public String getPrincipal(){//returns principal name
      return principal;
   }
   public int getNumTeachers(){//returns numTeachers
      return numTeachers;
   }
   //mutator methods
   public void setPrincipal(String p){//sets principals name
      principal = p;
   }
   public void setNumTeachers(int n){//sets numTeachers
      numTeachers = n;
   }
   //other methods
   public double calculateRatio(){//calculates ratio of teachers to students
      return (double)numTeachers/(super.getNumStudents());
   }
   public String toString(){//prints high school information
      return super.toString() + "Principal: " + principal + "\nNumber of teachers: " +
             numTeachers + "\nRatio of students to teachers: " + calculateRatio();
   }
}
   