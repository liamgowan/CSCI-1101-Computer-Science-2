/*Assignment 4, Part 1 CSCI 1101
LinkedList.java is used to create data structures using nodes. The only methods added by 
myself were the last three, which count the number of times that a given word is within
the list, return the last index of a node that contains a given word, and a method which
removes a node that contains a given word.
July 28, 2015
Liam Gowan B00673126
The last 3 methods of this program are entirely my own work and were created in lab 8. The rest was 
downloaded, as were instructed to do so from CSCI Moodle. Where applicable, all of this program has been
modified to accomodate Contacts instead of Strings.
*/
public class LinkedList
{
	private Node front;
	private int count;
	
	//constructor	
	public LinkedList()
	{
		front = null;
		count = 0;
	}
	
	//add a node to the front of the linked list
	public void addNodeToFront(Contact c)
	{
		Node n;
		n = new Node(c, front);
		front = n;
		count++;
	}
	
	//get the current size of the list
	public int size()
	{
		return count;
	}
	
	//check if the list is empty
	public boolean isEmpty()
	{
		if (front==null)
			return true;
		else
			return false;
	}
	
	//clear the list
	public void clear()
	{
		front = null;
		count=0;
	}
	
	
	
	//new method added - get the first node
	public Node getFront()
	{
		return front;
	}
	
	
	
	
	//scan the list and print contents
	public void enumerate()
	{
		Node curr = front;
		while (curr!=null)
		{
			System.out.println(curr);
			curr = curr.getNext();
		}
	}
	
	//remove front node
	public void removeFront()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			front = front.getNext();
			count--;
		}
	}
	
	

	
	//add a node to the end
	public void addNodeToEnd(Contact c)
	{
		Node n = new Node(c, null);
		Node curr = front;
		if (front==null)
			front = n;
		else
		{
			while (curr.getNext()!=null)
				curr = curr.getNext();
			curr.setNext(n);
		}
		count++;		
	}
	
	//remove last node
	public void removeLast()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else if (front.getNext()==null)
		{
			front = null;
			count--;
		}
		else
		{
			Node curr = front;
			while (curr.getNext().getNext()!=null)
				curr = curr.getNext();
			curr.setNext(null);
			count--;
		}
			
	}

	//search for a given data and return the index of the node (first occurrence)
	//return -1 if not found
	public int contains(Contact c)
	{
		Node curr = front;
		boolean found = false;
		int index = -1;
		while (curr!=null&&!found)
		{
			index++;
			if (curr.getContact().equalsContact(c))
				found=true;
			curr= curr.getNext();
		}
		if (!found)
			return -1;
		else
			return index;
		
	}
	
	//add a node at a given index
	public void add(int index, Contact c)
	{
		if (index<0 || index>size())
			System.out.println("Can't add. Index out of bounds");
		else
		{
	
			if (index==0)
				addNodeToFront(c);
			else
			{
				Node curr = front;
				for(int i=0; i<index-1; i++)
					curr = curr.getNext();
				Node n = new Node(c,curr.getNext());
				curr.setNext(n);
				count++;
			}
	   }	
	}
   
   public void addAlph(Contact c){//adds contact in alphabetical order
      if(size()==0)//First checks to see if the list is empty, if so it just adds it to the front
         addNodeToFront(c);
      else{
         //otherwise it will compare last names until it finds the first node that contains a Contact
         //object that has a "smaller" last name then it. It will then add it after that one.
         Node curr = front;
         int counter = 0;
         while(curr != null){
            if(c.getLastName().compareTo(curr.getLastName())<0){
               add(counter, c);
               break;
            }
            if(curr.getNext() == null){
               addNodeToEnd(c);
               break;
            }
            counter++;
            curr = curr.getNext();
         }
      }
   }
         
	//remove a node at a given index
	public void removeNode(int index)
	{
		if (index<0 || index>=size())
			System.out.println("Can't remove. Index out of bounds");
		else if (index==0)
			removeFront();
		else if (index==size()-1)
			removeLast();
		else
		{
			Node curr = front;
			for(int i=0;i<index-1;i++)
				curr = curr.getNext();
			curr.setNext(curr.getNext().getNext());
			count--;
		}
	}
	
	//get a node data given an index
	public Contact getContactAt(int index){
		Node curr = front;
		int i=0;
		while (curr!=null && i!=index)
		{
			curr=curr.getNext();
			i++;
		}
	   return(curr.getContact());
	}
}	