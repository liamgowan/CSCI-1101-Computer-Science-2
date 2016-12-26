/* Lab 5, Exercise 1 (FastFoodRestaurantDemo), CSCI 1101
FastFoodRestaurantDemo.java creates both a FastFoodRestaurant and a Restaurant object and tests their
methods to see if things work properly.
July 6, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class FastFoodRestaurantDemo{
   public static void main(String[] args){
      //makes FastFoodRestaurant object and prints it's toString() method
      FastFoodRestaurant f1 = new FastFoodRestaurant("Chicken Burger", 34);
      System.out.println(f1 + "\n\n");
      //makes Restaurant object and prints it's toString() method
      Restaurant r1 = new Restaurant("Chicken Burger", 34);
      System.out.print(r1);
   }
}