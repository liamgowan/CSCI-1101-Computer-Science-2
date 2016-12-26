/*Lab1, Part 2, Exercise 2, CSCI 1101
ShoeStoreOrderDemo.java holds will  create two ShoeStoreOrder objects, and display information about 
them in terms of pricing.
June 23, 2015
Liam Gowan B00673126
This is entirely my own work
*/
import java.util.Scanner;
public class ShoeStoreOrderDemo{
   public static void main(String[] args){
      System.out.println("Please enter information for the first shoe below.");
      //Creates new ShoeStoreOrder class, parameters call methods from this class to give variables
      ShoeStoreOrder order1 = new ShoeStoreOrder(askType(), askSeason(), askCost(), askBulkQuant(), askDiscount(), askAmount());
      System.out.println("\nPlease enter information for the second shoe below.");
      //Creates new ShoeStoreOrder class, parameters call methods from this class to give variables
      ShoeStoreOrder order2 = new ShoeStoreOrder(askType(), askSeason(), askCost(), askBulkQuant(), askDiscount(), askAmount());
      //Calls toString() method from ShoeStoreOrder.java, displays information
      System.out.println("\nOrder information for first order:\n" + order1.toString());
      System.out.println("\nOrder information for second order:\n" + order2.toString()); 
   }
   //The following methods have been added to reduce redundancies 
   public static String askType(){//asks user for shoe type
      Scanner input = new Scanner(System.in);
      System.out.print("Shoe: ");
      String type = input.nextLine();
      return type;
   }
   public static double askCost(){//asks user for shoe cost
      Scanner input = new Scanner(System.in);
      System.out.print("Cost: $ ");
      double cost = input.nextDouble();
      return cost;
   }
   public static String askSeason(){//asks user for season
      Scanner input = new Scanner(System.in);
      System.out.print("Season: ");
      String season = input.nextLine();
      return season;
   }
   public static int askBulkQuant(){//asks user for bulk quantity required
      Scanner input = new Scanner(System.in);
      System.out.print("Bulk quantity (to qualify for discount): ");
      int bulkQuantity = input.nextInt();
      return bulkQuantity;
   } 
   public static double askDiscount(){//asks user for discount
      Scanner input = new Scanner(System.in);
      System.out.print("Discount: ");
      double discount = input.nextDouble();
      return discount;
   } 
   public static int askAmount(){ //asks user for amount they want to buy
      Scanner input = new Scanner(System.in);
      System.out.print("Number sold: ");
      int amount = input.nextInt();
      return amount;
   }
}  