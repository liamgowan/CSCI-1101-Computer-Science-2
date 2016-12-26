/*Lab 8, Exercise 1, CSCI 1101
Node.java is used to create data structures. Each node point contains data, in this case a 
string, and points to the next Node in the sequence.
This was downloaded via CSCI Moodle.
July 18, 2015
Liam Gowan B00673126
This is not my work, as we were instructed to download this file, and not add anything to it.
*/
public class Node
{
	private String data;
	private Node next;
	public Node(String d, Node n)
	{
		data = d;
		next = n;
	}
	public String getData()
	{
		return data;
	}
	public Node getNext()
	{
		return next;
	}
	public void setData(String d)
	{
		data = d;
	}
	public void setNext(Node n)
	{
		next = n;
	}
	public String toString()
	{
		return data + "-->";
	}
}