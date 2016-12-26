/*Assignment 4, Part 1 CSCI 1101
AddressBookDemo.java creates an address book object. It then enters a while loop which prompts user to enter
1, 2, 3, 4 or 5. The number they enter will determine if the program will add a contact, display all contacts,
search for a contact(s), delete contacts, or quit the program.
July 28, 2015
Liam Gowan B00673126
*/
import java.util.Scanner;
public class AddressBookDemo{
   public static void main(String[] args){
      AddressBook myBook = new AddressBook();
      boolean quit = false;
      Scanner input = new Scanner(System.in);
      while(!quit){
         //prompts user for number
         System.out.print("\nEnter 1 to add contact, 2 to display, 3 to search, 4 to delete or 5 to quit: ");
         int choice = input.nextInt();
         while(choice<1 || choice>5){//ensures number is between 1 and 5
            System.out.println("Invalid option.");
            System.out.print("Enter 1 to add contact, 2 to display, 3 to search, 4 to delete or 5 to quit: ");
            choice = input.nextInt();
         }
         if(choice == 1)//if choice is 1, it will add a contact
            myBook.addAContact();
         else if(choice == 2)//if choice is 2, it will display all contacts
            myBook.displayAll();
         else if(choice == 3)//if choice is 3, it will search for a contact
            myBook.searchAndDisplay();
         else if(choice == 4)//if choice is 4, it will delete a contact
            myBook.deleteContact();
         else if(choice == 5)//if choice is 5, it will quit the program.
            quit = true;
      }
      System.out.print("Thank you for using the address book.");
   }
}
