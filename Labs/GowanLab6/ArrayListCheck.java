/*Lab 6, Exercise 2 (ArrayListCheck), CSCI 1101
ArrayListCheck.java is a procedural program which creates two lists. It then asks the user
to enter in words on one line, and once they are finished to enter "-1". It will add each 
word entered as an element to list1. It then removes duplicates of each word, and prints
list1 again, but only without the duplicate.
July 10, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListCheck{
   public static void main(String[] args){
      //makes two ArrayList's
      ArrayList<String> list1 = new ArrayList<String>();
      ArrayList<String> list2 = new ArrayList<String>();
      //The following block asks user to enter words, and doesn't stop adding them
      //to list1 until it reads "-1"
      System.out.println("Enter words on one line, end with -1");
      String entry;
      Scanner input = new Scanner(System.in);
      entry = input.next();
      while(!entry.equals("-1")){
         list1.add(entry);
         entry = input.next();
      }
      //makes list2 the same as list1, but in the opposite order
      for(int i=0; i<list1.size(); i++){
         list2.add(list1.get(list1.size()-1-i));
      }
      for(int i=0; i<list2.size(); i++){
      //if there is ever a time where the first index of an element is not the same
      //index as the last index of the same element, it will remove it, and decrease i
      //by one so that it can perform further testing for the same word.
         if(list2.indexOf(list2.get(i)) != list2.lastIndexOf(list2.get(i))){
            list2.remove(list2.get(i));
            i--;
         }
      }
      //clears list1, and makes it the same as list2, but in the opposite order
      list1.clear();
      for(int i=0; i<list2.size(); i++){
         list1.add(i, list2.get(list2.size()-1-i));
      }
      System.out.print("\nArray List with no duplicates: \n" +list1);
   }
}