/*Assignment 4, Part 1 CSCI 1101
AddressBook.java contains one attribute, which is a linked list. It has a constructor, a method to add 
contacts, a method to display all contacts, a method to search for an attribute of a contact, and a method
to show all contacts and then delete one.
July 28, 2015
Liam Gowan B00673126
*/
import java.util.Scanner;
public class AddressBook{
   //attributes
   private LinkedList list = new LinkedList();
   public AddressBook(){}//no args constructor
   public void addAContact(){//adds contact
      //first prompts user for information about contact
      Scanner input = new Scanner(System.in);
      String l, f, s, p;
      System.out.print("Enter last name: ");
      l = input.nextLine();
      System.out.print("Enter first name: ");
      f = input.nextLine();
      System.out.print("Enter street name: ");
      s = input.nextLine();
      System.out.print("Enter phone number: ");
      p = input.nextLine();
      Contact c = new Contact(l,f,s,p);//creates contact object
      list.addAlph(c);//uses addAlph method in LinkedList class to add contact in alphabetical order
   }
   public void displayAll(){//displays all contacts in list
      System.out.println();
      System.out.println("Name \t\t\t\t Street \t\t\t Number");
      list.enumerate();
   }
   public void searchAndDisplay(){
      /*Takes in a keyword, and then searches for all contacts that have that keyword as either a first or
      last name, street name, or phone number. */
      System.out.println();
      String keyword;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter what to search: ");
      keyword = input.nextLine();
      Node curr = list.getFront();
      boolean found = false;
      boolean firstFind=true;
      while(curr != null){//searches until end of list
         if((curr.getLastName().equals(keyword) ||//compares all attributes to see if all equal
            curr.getFirstName().equals(keyword) ||//and ensures that the "Name.. Street.. etc.." is only displayed once
            curr.getStreetName().equals(keyword) ||
            curr.getPhone().equals(keyword)) && firstFind){
            System.out.println("Name \t\t\t\t Street \t\t\t Number");//displays title
            System.out.println(curr);//calls Contact's toString
            found = true;
            firstFind = false;
         }
         else if(curr.getLastName().equals(keyword) ||//compares all attributes to see if equal
            curr.getFirstName().equals(keyword) ||
            curr.getStreetName().equals(keyword) ||
            curr.getPhone().equals(keyword)){//calls Contact's toString
            System.out.println(curr);
            found = true;
         }
         curr = curr.getNext();
      }
      if(found==false)
         System.out.println("\""+keyword+"\" not found in address book.");//displays  that keyword wasn't found
   }
   public void deleteContact(){
      System.out.println();
      if(list.size() == 0)//if list is empty, it will say there are no contacts
         System.out.print("No contacts to display.");
      else{
         int counter = 1;
         int toDelete;
         Scanner input = new Scanner(System.in);
         Node curr = list.getFront();
         System.out.println("Name \t\t\t Street \t\t\t Number");//displays title
         while(curr != null){
            System.out.println(counter + ". " + curr);//displays number of contact and contact toString
            counter++;//increases counter
            curr = curr.getNext();
         }
         //Prompts user for contact to delete
         System.out.print("\nEntry to delete: ");
         toDelete = input.nextInt();
         while(toDelete<0 || toDelete>list.size()){//ensures that there will not be any errors
            System.out.print("Entry must be within specific values. Entry to delete ");
            toDelete=input.nextInt();
         }  
         list.removeNode(toDelete-1);//removes contact
      }
   }       
}  