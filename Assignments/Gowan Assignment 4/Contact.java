/*Assignment 4, Part 1, CSCI 1101
Contact.java is used to create Contact objects. Each contact object contains a first name, a last name,
a street name and a phone number, all as String variables. It has a constructor, methods to get and set 
each variable, a method to see if it is the same as another contact, and a toString method.
July 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Contact{
   //attributes
   private String lastName;
   private String firstName;
   private String streetName;
   private String phone;
   //constructor
   public Contact(String l, String f, String s, String p){//creates Contact object, sets each attribute
      lastName = l;
      firstName = f;
      streetName = s;
      phone= p;
   }
   //accessor methods
   public String getLastName(){//returns last name
      return lastName;
   }
   public String getFirstName(){//returns first name
      return firstName;
   }
   public String getStreetName(){//returns street name
      return streetName;
   }
   public String getPhone(){//returns phone number
      return phone;
   }
   //mutator
   public void setLastName(String l){//sets last name
      lastName = l;
   }
   public void setFirstName(String f){//sets first name
      firstName = f;
   }
   public void setSteetName(String s){//sets street name
      streetName = s;
   }
   public void setPhone(String p){//sets phone number
      phone = p;
   }
   public boolean equalsContact(Contact c){//if all attributes of c are the same as "this"'s, return true
      if(firstName.equals(c.getFirstName()) &&
         lastName.equals(c.getLastName()) &&
         streetName.equals(c.getStreetName()) &&
         phone.equals(c.getPhone()))
         return true;
      return false;
   }
   public String toString(){//prints information about Contact object, 
      //ensures that contact info will be neatly presented
      if(lastName.length()+firstName.length()<=12&&streetName.length()>=7)
         return lastName + ", " + firstName + "\t\t\t" + streetName + "\t\t\t" + phone;
      else if(lastName.length()+firstName.length()<=12&&streetName.length()<7)
         return lastName + ", " + firstName + "\t\t\t" + streetName + "\t\t\t\t" + phone;
      else if(lastName.length() +firstName.length()>12&&streetName.length()>=7)
         return lastName + ", " + firstName + "\t\t\t" + streetName + "\t\t\t" + phone;
      else if(lastName.length() +firstName.length()>12&&streetName.length()<=5)
         return lastName + ", " + firstName + "\t\t\t" + streetName + "\t\t\t\t" + phone;
      return lastName + ", " + firstName + "\t\t\t" + streetName + "\t\t\t" + phone;
   }
}