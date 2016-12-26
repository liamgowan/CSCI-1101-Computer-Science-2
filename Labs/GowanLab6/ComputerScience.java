/*Lab 6, Exercise 1 (ComputerScience), CSCI 1101
ComputerScience.java is a subclass that extends the Course class. It has instance variables
that contain information about grades. It has a constructor which does not make an object
of it's super class. It has methods to get the grade array, a method to add a grade to the
grade array, a method to calculate the average of all the grades, and a toString method.
July 10, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class ComputerScience extends Course{
   //instance variables
   private double [] grades;
   private int numGrades;
   //constructor
   public ComputerScience(int num){//creates ComputerScience object
      grades = new double[num];//initiates grades as length of num
      numGrades = 0;//initiates numGrades to 0
   }
   //accessor method
   public double[] getGrades(){//returns grades array
      return grades;
   }
   public void addGrade(double grade){//adds an element of double type to grades
      grades[numGrades] = grade;
      numGrades++;
   }
   public void calculateFinalGrade(){
      //calculates the average of all grades, and uses it's superclasses's method to
      //set the superclasses's finalGrade
      double avgMark=0;
      for(int i=0; i<numGrades; i++){
         avgMark += getGrades()[i];
      }
      avgMark = avgMark/numGrades;
      super.setFinalGrade(avgMark);
   }
   public String toString(){
      //displays information about Course, and the number of grades
      String show = "";
      show += super.toString();
      show += "\nNumber of Grades: " + numGrades;
      return show;
   }     
}