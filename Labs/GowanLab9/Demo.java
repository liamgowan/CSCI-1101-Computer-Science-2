/*Lab 9, Exercise 1-3, CSCI 1101
Demo.java is used to create 3 LinkedLists and an ArrayList. It tests methods made
in this demo class. The first method adds all of the elements from list1 and list2 to list3,
but only if they aren't already in list3, and then ensures that list3 does not contain
any occurences if a given String. The second method takes in a LinkedList, and returns it
as an ArrayList. The third method will insert a String in the first place that it is in a
alphabetically higer position. 
July 20, 2015
Liam Gowan B00673126
*/
import java.util.ArrayList;
public class Demo{
   public static void main(String[] args){
      //creates two LinkedLists and adds String data to them
      LinkedList list1 = new LinkedList();
      LinkedList list2 = new LinkedList();
      System.out.println("***EXERCISE ONE***");
      list1.addToEnd("A");
      list1.addToEnd("B");
      list1.addToEnd("C");
      list1.addToEnd("D");
      list2.addToEnd("B");
      list2.addToEnd("D");
      list2.addToEnd("E");
      list2.addToEnd("F");
      //prints contents of list1 and list2
      list1.enumerate();
      list2.enumerate();
      LinkedList list3 = new LinkedList();//creates another LinkedList
      list3 = mergeRemove(list1, list2, "C");//makes list3 the result of this method with given parameters
      list3.enumerate();//prints contents of list3
      System.out.println("***EXERCISE TWO***");
      list3.enumerate();
      ArrayList<String> a = new ArrayList<String>(list3.size());//makes empty ArrayList
      a = convert(list3);//copies list3 into an ArrayList
      System.out.println(a);//prints contents of a
      System.out.println("***EXERCISE THREE***");
      list3.clear();
      list3.addToEnd("A");
      list3.addToEnd("B");
      list3.addToEnd("D");
      list3.addToEnd("E");
      insertAlpha(list3, "C");//inserts letter "C" alphabetically
      list3.enumerate();//Prints contents of list3
   }
   
   //adds all of the elements from list1 and list2 to list3, but only if they aren't 
   //already in list3, and then ensures that list3 doesn't t contain occurences of given 
   //word
   public static LinkedList mergeRemove(LinkedList list1, LinkedList list2, String word){
      LinkedList list3 = new LinkedList();//makes new LinkedList
      Node curr = list1.getFront();
      //adds all of list1 to list3, making sure there aren't duplicates
      while(curr != null){
         if(list3.contains(curr.getData()) == -1)
            list3.addToEnd(curr.getData());
         curr = curr.getNext();
      }
      curr = list2.getFront();
      //adds all of list2 to list3, making sure there aren't duplicates
      while(curr != null){
         if(list3.contains(curr.getData()) == -1)
            list3.addToEnd(curr.getData());
         curr = curr.getNext();
      }
      list3.remove(word);//uses remove method to get rid of 'word'
      return list3;//returns list3
   }
   //converts LinkedList to ArrayList
   public static ArrayList<String> convert(LinkedList list3){
      ArrayList<String> a = new ArrayList<String>(list3.size());
      Node curr = list3.getFront();
      //uses ArrayList add method to add each element of LinkedList using getData()
      while(curr != null){
         a.add(curr.getData());
         curr = curr.getNext();
      }
      return a;//returns ArrayList a
   }
   //Inserts a word into a list, but in alphabetical order
   public static void insertAlpha(LinkedList list, String s){
      if(list.size()==0)//if list is empty, it will add s to front
         list.addToFront(s);
      else{
         //otherwise, it will search whole list until it finds a node that contains data
         //that is 'less' than s, and will add itself at the location after it
         Node curr = list.getFront();
         int counter = 0;
         while(curr.getNext() != null){
            if(s.compareTo(curr.getData())<0){
               list.add(counter, s);
               break;
            }
            counter++;
            curr = curr.getNext();
         }
      }
   }
}