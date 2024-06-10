class LinkedList 
{
    class Node
    {
       int data;
       Node next;
       public Node(int data)
       {
          this.data=data;
       } 
    }
    Node head,tail;
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
        tail.next = null;
    }
    public void display()
    {
        if(head==null)
            System.out.println("List is Empty");
        else
        {
            Node temp=head;
            while(temp!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
    public void insertPosition(int pos,int data)
    {
        int c=0;
        Node n=new Node(data);
        Node temp=head;
        while(temp!=null)
        {
            if(c==pos-1)
            {
                n.next=temp.next;
                temp.next=n;
            }
            c++;
            temp=temp.next;
        }
    }
    public void insertBegining(int data)
    {
        Node n=new Node(data);
        n.next=head;
        head=n;
    }
    public void deleteBegin()
    {
        head=head.next;
    }
    public void deleteEnd()
    {
        Node temp=head;
        while(temp!=null)
        {
            if(temp.next==tail)
            {
                tail=temp;
                temp.next=null;
                break;
            }
            temp=temp.next;
        }
    }
    public void deletePosition(int pos)
    {
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            if(count==pos-1)
            {
                temp.next=temp.next.next;   
            }
            count++;
            temp=temp.next;
        }
    }
    public boolean delete(int data)
    {
        if (head == null)
            return false;
        Node temp = head;
        if (temp.data == data) {
            head = temp.next;
            return true;
        }
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            return true;
        }
        return false;
    }
    public void reverse()
    {
        Node prev=null;
        Node temp=head;
        Node next=null;
        while(temp!=null)
        {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;
    }

}
public class SinglyLinkedList
{
    public static void main(String arg[])
    {
        LinkedList l=new LinkedList();
        l.add(10);
        l.add(30);
        l.add(40);
        System.out.println("----NORMAL DISPLAY-&& INSERT END-----");
        l.display();
        System.out.println("----REVERSE LIST-----");
        l.reverse();
        l.display();
        System.out.println("-----INSERT BEGIN--------");
        l.insertBegining(5);
        l.display();
        System.out.println("---INSERT POSITION-------");
        l.insertPosition(2,20);
        l.display();
        System.out.println("----DELETE BEGIN------");
        l.deleteBegin();
        l.display();
        System.out.println("----DELETE END-----");
        l.deleteEnd();
        l.display();
        System.out.println("----DELETE POSITION-----");
        l.deletePosition(1);
        l.display();
        System.out.println("----DELETE BY DATA-----");
        boolean deleted = l.delete(30);
        if (deleted)
        l.display();
        else
        System.out.println(30+ " Not in List");
    }
}
