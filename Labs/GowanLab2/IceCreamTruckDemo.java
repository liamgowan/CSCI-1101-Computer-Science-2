/*Lab2 Exercise 3 Demo, CSCI 1101
IceCreamTruckDemo.java sets information about 8 ice cream truck objects, such as how many each
sells, total sold by all objects, the cost, truckID's and number of trucks in total.
It finds the total amount of trucks, the total made by all trucks and individual trucks,
and average per truck.
June 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/

public class IceCreamTruckDemo{
   public static void main(String[] args){
      //Creates 8 IceCreamTruck objects, assigns them their truckID in argument.
      IceCreamTruck truck1 = new IceCreamTruck("truck1");
      IceCreamTruck truck2 = new IceCreamTruck("truck2");
      IceCreamTruck truck3 = new IceCreamTruck("truck3");
      IceCreamTruck truck4 = new IceCreamTruck("truck4");
      IceCreamTruck truck5 = new IceCreamTruck("truck5");
      IceCreamTruck truck6 = new IceCreamTruck("truck6");
      IceCreamTruck truck7 = new IceCreamTruck("truck7");
      IceCreamTruck truck8 = new IceCreamTruck("truck8");
      truck1.setCost(3.25);//sets cost for ALL trucks
      //The following sets each object's sales, with the number (2nd arg) indicating 
      //how many they sold.
      makeThemSell(truck1, 10);
      makeThemSell(truck2, 25);
      makeThemSell(truck3, 47);
      makeThemSell(truck4, 310);
      makeThemSell(truck5, 8);
      makeThemSell(truck6, 22);
      makeThemSell(truck7, 6);
      makeThemSell(truck8, 32);
      //Displays information for each truck about truckID, total sold per truck, and money made
      System.out.println("Ice-cream Sales by Truck:");
      System.out.println(truck1);
      System.out.println(truck2);
      System.out.println(truck3);
      System.out.println(truck4);
      System.out.println(truck5);
      System.out.println(truck6);
      System.out.println(truck7);
      System.out.println(truck8 + "\n"); 
      //Displays total ice creams sold by all 8 trucks
      System.out.println("Total Ice-creams sold by all trucks: " + truck1.getTotalSold()); 
      //Displays total sales by all 8 trucks
      System.out.println("Total sales: $" + truck1.findTotalSales());
      //Displays average sales by all 8 trucks
      System.out.println("Average sales per truck: $" + truck1.findAverageSales());
      System.out.print("\nProcess completed.");  
   }
   
   public static void makeThemSell(IceCreamTruck truck, int numTruckHasSold){
   //Makes a sale happen for whatever numTruckHasSold is
      for(int i=0; i<numTruckHasSold; i++){
         truck.sale();
      }
   }
         
}