/*Lab 7, Exercise 1, CSCI 1101
E1.java is a procedural program which creates three lists. It then asks the user
to enter in integers on one line, and once they are finished to enter -1, twice, which adds the numbers
entered into two different array lists. It then checks to see if both array lists contain the same numbers.
The numbers that are not common in both array lists, are added to the third Array List, int3.
July 14, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class E1{
   public static void main(String[] args){
      //creates 3 ArrayLists
      ArrayList<Integer> int1 = new ArrayList<Integer>(20);
      ArrayList<Integer> int2 = new ArrayList<Integer>(20);
      ArrayList<Integer> int3 = new ArrayList<Integer>(40);
      Scanner input = new Scanner(System.in);
      //Until line 30, the following asks user for integers and adds them to two array lists
      System.out.println("Enter the first set of integers on one line, end with -1");
      int num = input.nextInt();
      while(!(num == -1)){
         int1.add(num);
         num = input.nextInt();
      }
      System.out.println("\nEnter the second set of integers on one line, end with -1");
      num = input.nextInt();
      while(!(num == -1)){
         int2.add(num);
         num = input.nextInt();
      }
      //Until line 40, the following code checks to see if any of the integers in one Array List are in
      //the other. If it isn't, it will add the integer to int3. 
      for(int i=0; i<int1.size(); i++){
         if(!int2.contains(int1.get(i)))
            int3.add(int1.get(i));
      }
      for(int i=0; i<int2.size(); i++){
         if(!int1.contains(int2.get(i)))
            int3.add(int2.get(i));
      }
      System.out.println("\nArray List with different Integers:");
      System.out.print(int3);  
   }
} 