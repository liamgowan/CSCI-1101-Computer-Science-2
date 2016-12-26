/*Lab2 Exercise 3, CSCI 1101
IceCreamTruck.java stores information about ice cream truck objects, such as how many each
sells, total sold by all objects, the cost, truckID's and number of trucks in total.
It has methods to set and get these variables, find the total sales and average sales per truck
June 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class IceCreamTruck{
   //instance variables
   private String truckID;
   private int numOfIceCreamSoldByTruck;
   private static int iceCreamsSold = 0;
   private static double iceCreamCost;
   private static int numOfTrucks = 0;
   
   //constructor
   public IceCreamTruck(String truckID){
   //creates object, sets truckID, numbers of ice creams sold, and increases the total number of trucks.
      this.truckID = truckID;
      numOfIceCreamSoldByTruck = 0;
      numOfTrucks++;
   }
   
   //accessors
   
   public String getTruckID(){//returns truckID
      return truckID;
   }
   
   public int getNumOfIceCreamSoldByTruck(){//returns the number of ice creams sold by that truck
      return numOfIceCreamSoldByTruck;
   }
   
   public double getIceCreamCost(){//returns ice cream cost
      return iceCreamCost;
   }
   
   public void sale(){
      numOfIceCreamSoldByTruck++; //Increases num of ice cream sold by particular truck
      iceCreamsSold++; //increases total num of ALL ice creams sold by ALL trucks
      
   }
   
   public String toString(){
      //displays how many ice creams sold were sold by a certain truck, and total sales for that truck
      return "Ice-creams sold by " + getTruckID() + ": " + getNumOfIceCreamSoldByTruck() + 
              "  Total Sales for " + getTruckID() + ": $" + (getNumOfIceCreamSoldByTruck() * getIceCreamCost());
   }
   
   public static int getTotalNumOfTrucks(){//returns (static) number of trucks in total
      return numOfTrucks;
   }
   
   public static void setCost(double cost){//sets the cost of ice cream for all IceCreamTruck objects
      iceCreamCost = cost;
   }
   
   public static int getTotalSold(){//returns the total number of all ice creams sold by all trucks
      return iceCreamsSold;
   }
   
   public static double findTotalSales(){//calculates and returns the total sales of all trucks
      return iceCreamCost * getTotalSold();
   }
   
   public static double findAverageSales(){//calculates and returns the average sales per truck
      return findTotalSales()/getTotalNumOfTrucks();
   }
}