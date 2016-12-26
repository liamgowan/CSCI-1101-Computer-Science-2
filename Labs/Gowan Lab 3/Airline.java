/*Lab3, Exercise 2 (Airline), CSCI 1101
Airline.java has instance variables for the name of the airline and the the number of
plane objects created. It also has a Plane array. It has methods to create an Airline object,
methods to get the name and total planes, methods to find the total amount of passengers and seats on all plane objects
in it's Plane array, methods to get the plane array and certain planes from that array, a method to add planes
to find the percentage of all seats on all seats taken up by all passengers, and a toString method.
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/

public class Airline{
   //instance variables
   private int totalPlanes;
   private String name;
   private Plane[] allPlanes;
   
   //constructor
   public Airline(String name){
      //sets name, totalPlanes to 0, and sets allPlanes to hold 10 Plane objects
      this.name = name;
      totalPlanes = 0;
      allPlanes = new Plane[10];
   }
   
   //accessor methods
   public String getName(){//returns name of airline
      return name;
   }
       
   public int getTotalPlanes(){//returns total planes
      return totalPlanes;
   }
   public int getTotalPassengers(){
      //method finds how many passengers there are total on all planes
      int counter = 0;
      for(int i=0; i<allPlanes.length && allPlanes[i] != null; i++){
         counter += allPlanes[i].getNumPassengers();
      }
      return counter;
   }
   public int getTotalSeats(){
      //method finds how many seats there are total on all planes
      int counter = 0;
      for(int i=0; i<allPlanes.length && allPlanes[i] != null; i++){
         counter += allPlanes[i].getNumSeats();
      }
      return counter;
   }
   public Plane[] getAllPlanes(){//returns allPlanes array
      return allPlanes;
   }
   public Plane getCertainPlane(int i){//returns certain plane of index i
      return allPlanes[i];
   }
   //mutator method
   public void setName(String n){//sets name of airline
      name = n;
   }
   public void addPlane(Plane p){
      //adds Plane object to allPlanes array, increases totalPlanes
      for(int i=0; i<allPlanes.length ; i++){
         //if statement and break ensure that only one element will be added to array 
         if(allPlanes[i] == null){
            allPlanes[i] = p;
            totalPlanes++;
            break;
         }
      }  
   }
   
   public double percentageFull(){
      //returns percentage of passengers of all planes taking up seats on all planes
      return (double)getTotalPassengers()/getTotalSeats()*100;
   }  
   
   public String toString(){
      return "\n" + name + " has " + totalPlanes + " planes in total, and " + getTotalPassengers() + 
      " passengers in total.";
   }
}