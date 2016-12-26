/*Lab 4, Exercise 1 (EncyclopediaDemo), CSCI 1101
EncyclopediaDemo.java creates an encyclopedia object (which in turn creates a book object),
and prints out the number of pages and topics it has, as well as the number of topics per page.
July 3rd, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class EncylopediaDemo{
   public static void main(String[] args){
      Encyclopedia e1 = new Encyclopedia(262, 300);//makes encyclopedia object
      System.out.println("Pages: " + e1.getPages());//prints number of pages
      System.out.println("Topics: " + e1.getTopics());//prints number of topics
      System.out.print("Topics per page: " + e1.computeTopicsPerPage());//prints # of pages/topics
   }
}