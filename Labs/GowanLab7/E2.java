/*Lab 7, Exercise 2, CSCI 1101
E2.java is a procedural program which creates three lists. It then asks the user
to enter in words on one line, and once they are finished to enter "-1", twice, which adds the words
entered into two different array lists. It then checks to see if both array lists contain any of the
same words, and the common words will be added to Array List, 'list3'.
July 14, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class E2{
   public static void main(String[] args){
      //creates 3 Array Lists
      ArrayList<String> list1 = new ArrayList<String>(20);
      ArrayList<String> list2 = new ArrayList<String>(20);
      ArrayList<String> list3 = new ArrayList<String>(20);
      Scanner input = new Scanner(System.in);
      //Until line 31, asks user for two lines of words, adds them to two separate Array Lists.
      System.out.println("Enter words on one line, end with -1");
      String word = input.next();
      while(!word.equals("-1")){
         list1.add(word);
         word = input.next();
      }
      System.out.println("Enter words on one line, end with -1");
      word = input.next();
      while(!word.equals("-1")){
         list2.add(word);
         word = input.next();
      }
      //checks to see if list2 contains a certain element, and if list3 doesn't already contain it,
      //if so it will add it to list3
      for(int i=0; i<list1.size(); i++){
         if(list2.contains(list1.get(i)) && !list3.contains(list1.get(i)))
            list3.add(list1.get(i));
      }
      //prints the 3 lists
      System.out.println(list1);
      System.out.println(list2);
      System.out.println("Array List with common strings:");
      System.out.println(list3);
   }
}
      