/*Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.
Assume the values are unique if there is no loop and values repeat if there is a loop.
The algorithm should be an order or n algorithm. So if you traverse the list twice it is not accepted. The loop can run only once in the
detectloop function. */

/* Python & C students can delete this code & write a clean one from scratch */
import java.util.*;
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

public class SinglyCycle 
{
	Node head; // head of linked list

	boolean detectloop()
	{
	    Node temp1 = head;
	    while(temp1.next!=null)
	    {
	        Node temp2=temp1.next;
	        while(temp2!=null)
	        {
	            if(temp2.data==temp1.data)
	                return true;
	            temp2=temp2.next;
	        }
	        temp1=temp1.next;
	    }
     
        //add your code here...
        
        return false;
	}

	/* Inserts a new Node at front of the list. */
	public void add(int new_data)
	{
		Node new_node = new Node(new_data);
  	    new_node.next = head;
	    head = new_node;
	}

	public static void main(String [] args)
	{
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
		SinglyCycle  llist = new SinglyCycle ();
		for (int i=1; i<=n; ++i)
		{
		    int l = sc.nextInt();
			llist.add(l);
		}
        sc.close();
		if(llist.detectloop())
		   System.out.println("LOOP");
		else
		   System.out.println("NO LOOP");
	}
}
/*5=>12345=>NO LOOP
 5=>12343=>LOOP
 */