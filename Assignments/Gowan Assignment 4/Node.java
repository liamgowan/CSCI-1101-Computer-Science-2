/*Assignment 4 Part 1, CSCI 1101
Node.java is used to create data structures. Each node point contains data, in this case a 
Contact object, and points to the next Node in the sequence.
This was downloaded via CSCI Moodle.
July 28, 2015
Liam Gowan B00673126
This is not entirely my work, as we were instructed to download this file, however it has been modified 
to hold data about Contact objects instead of String objects.
*/
public class Node
{
	private Contact c;
	private Node next;
	public Node(Contact c, Node n)
	{
		this.c = c;
		next = n;
	}
   public Contact getContact(){
      return c;
   }
   public String getLastName(){
      return c.getLastName();
   }
   public String getFirstName(){
      return c.getFirstName();
   }
   public String getStreetName(){
      return c.getStreetName();
   }
   public String getPhone(){
      return c.getPhone();
   }
	public Node getNext()
	{
		return next;
	}
   public void setContactData(Contact newCon){
      c = newCon;
   }
	public void setNext(Node n)
	{
		next = n;
	}
   public String toString(){
      return c.toString();
   }
}