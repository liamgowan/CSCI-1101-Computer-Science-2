/*Lab 6, Exercise 1 (ComputerScienceDemo), CSCI 1101
ComputerScienceDemo.java creates a ComputerScience object. It then sets the course name and 
instructor name. It then asks the user to enter in the final marks of 15 students. Then,
it finds the average of these 15 students, and uses the ComputerScience object's toString
method.
July 10, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class ComputerScienceDemo{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      ComputerScience c1 = new ComputerScience(15);
      c1.setName("CSCI 1101");
      c1.setInstructor("Bonnie MacKay");
      for(int i=0; i<15; i++){
         System.out.print("Enter mark for student " + (i+1) + ": ");
         c1.addGrade(input.nextDouble());
      }
      c1.calculateFinalGrade();
      System.out.print(c1);
         
   }
}