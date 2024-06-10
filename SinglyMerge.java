import java.util.*;
public class SinglyMerge
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        LinkedList1 l=new LinkedList1();
        LinkedList1 m=new LinkedList1();
        l.add(20);
        l.add(30);
        m.add(10);
        m.add(15);
        l.display();
        m.display();
        l.mergeList(m);
        System.out.println("------------");
        l.display();
        // m.display();
        sc.close();
    }
}
class LinkedList1
{
    Node head,tail;
    private class Node
    {
        private int data;
        private Node next;
        public Node(int data)
        {
            this.data=data;
        }
    }
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
            tail.next=n;
            tail=n;
        }
        tail.next=null;
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
    public void mergeList(LinkedList1 m)
    {
        tail.next=m.head;
        tail=m.tail;
    }
}

