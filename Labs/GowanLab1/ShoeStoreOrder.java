/*Lab1, Part 2, Exercise 2, CSCI 1101
ShoeStoreOrder.java holds will hold information about a shoe, can create a ShoeStoreOrder object,
and contains methods to calculate cost of the order depending on cost of shoes at regular price, 
quantity required for discount, discount and total amount ordered
June 23, 2015
Liam Gowan B00673126
This is entirely my own work
*/
public class ShoeStoreOrder{
   //instance variables
   private String type;
   private String season;
   private double shoeCost;
   private int bulkOrderQuantity;
   private double discount;
   private int totalOrdered;
   private double totalAmount;
   private double totalDiscount;  
   //constructor (assigns all instance variables)
   public ShoeStoreOrder(String type, String season, double shoeCost, int bulkOrderQuantity,
                        double discount, int amount){
      this.type = type;
      this.shoeCost = shoeCost;
      this.season = season;
      this.bulkOrderQuantity = bulkOrderQuantity;
      this.discount = discount;
      this.totalOrdered = amount;
   }
   //Accessor methods
   public String getType(){//gets shoe type
      return type;
   }
   public String getSeason(){//gets shoe season
      return season;
   }
   public double getShoeCost(){//gets shoe cost
      return shoeCost;
   }
   public int getBulkOrderQuantity(){//gets bulkOrderQuantity
      return bulkOrderQuantity;
   }
   public double getDiscount(){//gets discount
      return discount;
   }
   public int getTotalOrdered(){//gets total ordered
      return totalOrdered;
   }
   //Mutator methods
   public void setType(String type){//sets type
      this.type = type;
   }
   public void setSeason(String season){//sets season
      this.season = season;
   }
   public void setShoeCost(double type){//sets shoe cost
      this.shoeCost = shoeCost;
   }
   public void setBulkOrderQuantity(int bulkOrderQuantity){//sets bulk order quantity
      this.bulkOrderQuantity =bulkOrderQuantity;
   }
   public void setDiscount(double discount){//sets discount
      this.discount = discount;
   }
   public void setTotalOrdered(int totalOrdered){//sets total ordered
      this.totalOrdered = totalOrdered;
   }
   
   //other methods
   
   public double order(int n){//determines cost of order
      if(n >= getBulkOrderQuantity()){
         return n * getShoeCost() - n * getShoeCost() * getDiscount()/100;
      }
      else{ 
         return n * getShoeCost();
      }
   }
   private double findTotalDiscount(){//determines discount amount
      double discount = getShoeCost() * getTotalOrdered() - order(getTotalOrdered());
      return discount;
   }
   private String findTotalWithoutDiscount(){
   //returns string telling user what they would have paid discount didn't apply
      if(getTotalOrdered()>=getBulkOrderQuantity())
         return "\nWithout the discount, your order would have been: " + (getTotalOrdered() * getShoeCost());
      return "";
   }
   public void displayOrder(){//returns information about order
      System.out.println("Shoe: " + getType()+
                         "\nSeason: " + getSeason()+
                         "\nNumber Ordered: " + getTotalOrdered()+
                         "\nTotal Amount: $ " + order(getTotalOrdered()));
      System.out.print("Total Discount: $ " + findTotalDiscount() + "\n" +
                       findTotalWithoutDiscount());
   }
   public String toString(){//returns information about order
      return "Shoe: " + getType()+ "\nSeason: " + getSeason()+
             "\nNumber Ordered: " + getTotalOrdered()+"\nTotal Amount: $ " 
             + order(getTotalOrdered()) + "\nTotal Discount: $ " + findTotalDiscount() + 
             findTotalWithoutDiscount();
   }
}