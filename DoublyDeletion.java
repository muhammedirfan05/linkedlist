// import java.util.*;
public class DoublyDeletion
{
    public static void main(String[] args) 
    {
        LinkedList4 l=new LinkedList4();
        l.add(10);
        l.add(20);
        l.add(30);
        l.display();
        if(l.remove(2)) System.out.println("removed");
        else    System.out.println("error");
        l.display();
    }
}
class LinkedList4
{
    private class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data=data;
        }
    }
    Node head,tail;
    int c=0;
    public void add(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }
        else
        {
            n.prev=tail;
            tail.next=n;
            n.next=null;
            tail=n;
        }
        c++;
    }
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public boolean remove(int pos) 
    {
        if (pos == 0) 
        { 
            head = head.next;
            head.prev = null;
            c--;
            return true;
            
        } 
        else if (pos == c - 1) 
        { 
            tail = tail.prev;
            tail.next = null;
            c--;
            return true;
        }
        else 
        { 
            Node temp = head;
            int f = 0;
            while (temp != null) 
            {
                if (pos == f)
                {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                    c--;
                    return true;
                }
                temp = temp.next;
                f++;
            }
        }
        return false;
    }
}    