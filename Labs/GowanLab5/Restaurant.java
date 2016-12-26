/* Lab 5, Exercise 1 (Restaurant), CSCI 1101
Restaurant.java has two instance variables, one for the name of a restaurant and the other for
the number of seats. It has a constructor that sets the name and seats. It also has get and set
methods. It also has a toString method.
July 6, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Restaurant{
   //instance variables
   private String name;
   private int numSeats;
   //constructors
   public Restaurant(String name, int numSeats){
      //initializes name and numSeats
      this.name=name;
      this.numSeats=numSeats;
   }
   //accessors
   public String getName(){//returns name
      return name;
   }
   public int getNumSeats(){//returns numSeats
      return numSeats;
   }
   //mutators
   public void setName(String name){//sets name
      this.name=name;
   }
   public void setNumSeats(int numSeats){//sets numSeats
      this.numSeats=numSeats;
   }
   public String toString(){//returns name and numSeats
      return "Restaurant name: " + name + "\nNumber of seats: " + numSeats;
   }
}
   
      
   