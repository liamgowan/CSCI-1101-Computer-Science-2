 /*Lab1, Part 2, Exercise 1, CSCI 1101
CircleDemo.java is a demo class for the Circle class. It can create the Circle objects and assign
information to them, which will then be printed later.
June 22, 2015
Liam Gowan B00673126
This is entirely my own work
*/

import java.util.Scanner;
public class CircleDemo{
   public static void main(String[] args){
      //Prompts user for radius, assigns to 'radius'
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the radius: ");
      double r = input.nextDouble();
      System.out.print("Enter the colour: ");
      //Prompts user for colour, assigns to 'colour'
      String a = input.nextLine();//ensures that colour will be saved to 'c'
      String c = input.nextLine();
      Circle cir1 = new Circle(r, c); //creates Circle object called cir1
      System.out.println("\n" + cir1.toString()); //prints information about cir1
      System.out.print("Circumference: " + cir1.findCircumference()); //prints circumference of circl
   }
}