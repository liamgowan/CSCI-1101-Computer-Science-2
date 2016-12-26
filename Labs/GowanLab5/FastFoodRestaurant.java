/* Lab 5, Exercise 1 (FastFoodRestaurant), CSCI 1101
FastFoodRestaurant.java has a constructor that sets the name and seats of a Restaurant object. 
It has a getNumSeats method which returns the number of seats multiplied by 2. It has a toString method
which prints information about the FastFoodRestaurant
July 6, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class FastFoodRestaurant extends Restaurant{
   //constructor
   public FastFoodRestaurant(String n, int s){//takes in a String and int, passes to super
      super(n,s);
   }
   public int getNumSeats(){//will return the number of seats that restaurant object has, 
                            //multiplied by 2, overrides Restaurant's getNumSeats()
      return super.getNumSeats() * 2;
   }
   public String toString(){//prints information about FastFoodRestaurant
      return "Welcome to " + super.getName() + " with " + getNumSeats() + " seats. " 
             + "Best Burgers Ever!";
   }
}