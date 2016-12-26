/*Lab3, Exercise 2 (Plane), CSCI 1101
Plane.java has instance variables for the name of the plane, the number of seats on the plane, 
and the number of passengers on board the plane. It has methods to create a plane object, get and set
methods for the instance variables, a method to add more passengers, a method to tell whether 'this'
plane object or another plane object has more seats, a toString method, and a method to copy itself.
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/

public class Plane{
   //instance variables
   private String planeName;
   private int numSeats;
   private int numPassengers;
   
   //contructor sets Plane name, numSeats, and numPassengers to 0
   public Plane(String name, int numSeats){
      planeName = name;
      this.numSeats = numSeats;
      numPassengers = 0;
   }
   //accessors
   public String getName(){//returns name
      return planeName;
   }
   public int getNumSeats(){//returns numSeats
      return numSeats;
   }
   public int getNumPassengers(){//returns numPassengers
      return numPassengers;
   }
   //mutators
   public void setName(String n){
      planeName = n;
   }
   public void setNumSeats(int n){
      numSeats = n;
   }
   public void setNumPassengers(int n){
      numPassengers = n;
   }
   
   public void addPassengers(int num){
      //method first checks to see if the number of passengers is equal to the number of seats,
      //if it is, it will say it can't hold more people
      if(numPassengers == numSeats)
         System.out.print("\nSorry, " + planeName + " cannot hold any more passeners.");
      //if false, method will check if num plus number of current passengers on board is greater
      //than the number of seats, if it is, it will say how many people can still fit on board.
      else if(num + numPassengers > numSeats)
         System.out.print("\nSorry, " + planeName + " only has room for " + (numSeats - numPassengers) 
         + " more passengers on board.");
      else
         //otherwise, it will add num to he num of passengers
         numPassengers += num;
   }
   
   public boolean hasMoreSeats(Plane p){
      //this method will return true if 'this' plane has more seats than 'p'.
      //Otherwise it will return false.
      if(getNumSeats()>p.getNumSeats())
         return true;
      return false;
   }
   
   public String toString(){
      return planeName + "has " + numSeats + " seats and" + numPassengers + " passengers onboard.";
   }
   
   public Plane copy(Plane p){
      //makes a copy of plane p
      p.setName(planeName);
      p.setNumSeats(numSeats);
      p.setNumPassengers(numPassengers);
      return p;
   }
}
   