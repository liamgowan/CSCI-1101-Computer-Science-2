/*Lab 8, Exercise 1, CSCI 1101
Demo.java creates a LinkedList object. It then adds 9 Node objects to the list. It then 
tests the enumerate method, the method to count the number of occurences of a word in the
list, the method to return the last index of a word, and the method to remove 
July 18, 2015
Liam Gowan B00673126
The last 3 methods of this program are entirely my own work. The rest was downloaded, as were
instructed to do so from CSCI Moodle.
*/
public class Demo{
   public static void main(String[] args){
      LinkedList list1 = new LinkedList();//creates LinkedList object
      //following lines create nodes and add to end of list
      list1.addToEnd("Tacos");
      list1.addToEnd("Bears");
      list1.addToEnd("Cats");
      list1.addToEnd("Trees");
      list1.addToEnd("Vines");
      list1.addToEnd("Ice");
      list1.addToEnd("Bears");
      list1.addToEnd("Bears");
      list1.addToEnd("Cat");
      list1.enumerate();//prints contents
      //prints how many times "Bears" is in list
      System.out.println("Bears appears: " + list1.countWord("Bears") +" time(s)");
      //prints how many times "Cats" is in list
      System.out.println("Cats appears: " + list1.countWord("Cats") +" time(s)");
      //prints how many times "Lasagna" is in list
      System.out.println("Lasanga appears: " + list1.countWord("Lasanga") +" time(s)");
      //prints last index of "Bears"
      System.out.println("The last index of Bears is " + list1.lastIndexOf("Bears"));
      //prints last index of "Cactus"
      System.out.println("The last index of Cactus is " + list1.lastIndexOf("Cactus"));
      list1.remove("Bears");//removes all occurences of "Bears"
      list1.remove("Hamsters");//since "Hamsters" isn't in list, it should tell user this
      list1.enumerate();//prints contents that are list
   }
}
         