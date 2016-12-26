/*Lab 4, Exercise 1 (Book), CSCI 1101
Book.java creates book objects. It has one instance variable that holds the number of pages.
It has a constructor which sets numPages. It has accessor/mutator methods to get and set numPages.
July 3rd, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

public class Book{
   //instance variable
   private int numPages;
   //constructor
   public Book(int n){//makes Book object, sets numPages
      numPages = n;
   }
   //accessor method
   public int getPages(){//gets pages
      return numPages;
   }
   //mutator method
   public void setPages(int n){//sets pages
      numPages = n;
   }
}
   