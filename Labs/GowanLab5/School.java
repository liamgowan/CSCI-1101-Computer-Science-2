/* Lab 5, Exercise 2 (School), CSCI 1101
School.java has instance variables for the number of students and name of the school. It also has
a constructor that sets the name of a School object. It has get and set methods, as well as a 
toString method which prints information about the School object. 
July 6, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class School{
   //instance variables
   private int numStudents;
   private String name;
   //constructor
   public School(String name){//makes School object, sets name
      this.name = name;
   }
   //accessor methods
   public String getName(){//returns name
      return name;
   }
   public int getNumStudents(){//returns numStudents
      return numStudents;
   }
   //mutator methods
   public void setNumStudents(int s){//sets number of students
      numStudents = s;
   }
   public void setName(String n){//sets name
      name = n;
   }
   //other methods
   public String toString(){//prints information about school
      return "School Name: " + name + "\nNumber of students: " + numStudents + "\n";
   }
}
   
   
      
