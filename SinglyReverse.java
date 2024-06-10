import java.util.*;

public class SinglyReverse {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList3 l = new LinkedList3();
        l.add(20);
        l.add(30);
        l.display();
        l.reverse();
        l.display();
        int mid=l.getMidValue();
        System.out.println("MID VALUE=>"+mid);
        sc.close();
    }
}
class LinkedList3 {
    Node head, tail;
    int count = 0; 

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        tail.next = null;
        count++; 
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("--->" + count);
    }

    public void reverse() {
        Node temp = head, prev = null, next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
    }
    public int getMidValue()
    {
        Node temp=head;
        int c1=-1;
        while(temp.next!=null)
        {
            if(c1==count/2)
                return temp.data;
            c1++;
        }
        return -01;
    }
}
