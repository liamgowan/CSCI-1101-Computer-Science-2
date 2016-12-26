/*Lab 4, Exercise 1 (Encyclopedia), CSCI 1101
Encyclopedia.java is the subclass of Book. It creates encyclopedia objects, and book objects. 
It has one instance variable that holds the number of topics.
It has a constructor which sets numTopics. It has accessor/mutator methods to get and set numTopics.
It has a method to return the number of pages per topic.
July 3rd, 2015
Liam Gowan B00673126
This is entirely my own work.
*/ 

public class Encyclopedia extends Book{
   //instance variable
   private int numTopics;
   //constructor
   public Encyclopedia(int p, int t){//makes Encyclopedia object
      super(p);//makes book object
      numTopics = t;//sets numTopics
   }
   //accessor method
   public int getTopics(){//return numTopics
      return numTopics;
   }
   //mutator method
   public void setTopics(int t){
      numTopics = t;
   }
   //other methods
   public double computeTopicsPerPage(){//calculates topics per page as a double
      return (double)getTopics()/getPages();
   }
}
   