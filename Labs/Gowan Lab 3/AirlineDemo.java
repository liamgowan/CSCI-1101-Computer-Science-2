/*Lab3, Exercise 2 (AirlineDemo), CSCI 1101
AirlineDemo.java creates an Airline object and 3 Plane objects, and adds those Plane objects to the
Airline object's Plane array. It then adds passengers to test the logical checks. It tests to see
if the methods in Airline.java and Plane.java classes work. 
June 29, 2015
Liam Gowan B00673126
This is entirely my own work
*/

public class AirlineDemo{
   public static void main(String[] args){
      Airline myAirline = new Airline("Gowan Jet");//creats Airline object
      //creates 3 plane objects
      Plane plane1 = new Plane("Vomit Comit", 600);
      Plane plane2 = new Plane("Flight 815", 400); 
      Plane plane3 = new Plane("Liam's Plane", 750);
      Plane planeWithMostSeats = plane1.copy(plane1);//this is meant to later hold which plane holds the most seats
      //adds passengers to planes
      plane1.addPassengers(600);
      plane1.addPassengers(450);
      plane2.addPassengers(324);//Flight 815 will have 324 passengers (for Lost reference)
      plane3.addPassengers(200);
      plane3.addPassengers(60);
      //adds the planes to the Airline Plane array
      myAirline.addPlane(plane1);
      myAirline.addPlane(plane2);
      myAirline.addPlane(plane3);
      //tests to see if Airline can find how many Plane objects it ihas
      System.out.println("\n" +myAirline.getName() + " has a fleet of " + myAirline.getTotalPlanes()+" planes.");
      System.out.print("Planes ");
      //Lists name of each Plane in Airline class, finds total passengers
      for(int i = 0; i<myAirline.getTotalPlanes(); i++){
         if(i+1<myAirline.getTotalPlanes())  
            System.out.print(myAirline.getCertainPlane(i).getName() + ", ");
         else if(i == myAirline.getTotalPlanes() - 1)
            System.out.print("and " + myAirline.getCertainPlane(i).getName()) ;
      }
      System.out.println( " have a total of " + myAirline.getTotalPassengers() + " passengers");
      //tries to add more passengers
      plane2.addPassengers(300);
      plane2.addPassengers(30);
      //finds and displays percentage of ALL seats on ALL Planes by ALL passengers
      double percentage = myAirline.percentageFull();
      System.out.printf("\nPercentage full: %.2f%%", percentage);
      //finds and displays which plane has the most seats
      for(int i=0; i<myAirline.getTotalPlanes(); i++){
         if(myAirline.getCertainPlane(i).hasMoreSeats(planeWithMostSeats)){
            planeWithMostSeats = myAirline.getCertainPlane(i).copy(myAirline.getCertainPlane(i));
         }
      }
      System.out.println("\n" + planeWithMostSeats.getName() + " has the most seats.");
      System.out.print(myAirline);//tests toString() method
   }  
}