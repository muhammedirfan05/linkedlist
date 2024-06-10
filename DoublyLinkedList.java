import java.util.*;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLinkedList l = new DLinkedList();
        l.add(10);
        l.add(20);
        l.add(30);
        l.display();
        System.out.println("REVERSE DISPLAY");
        l.reverse();
        l.insert(1, 15);
        l.display();
        sc.close();
    }
}

class DLinkedList {
    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head, tail;
    int count = 0;

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
            n.next = null;
        }
        count++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("Count: " + count);
    }

    public void reverse() {
        Node temp = tail;
        while (temp != head) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
        System.out.println(head.data);
    }

    public void insert(int pos, int value) {
        Node n = new Node(value);
        if (pos <= 0) 
        { 
            n.next = head;
            head.prev = n;
            head = n;
        } 
        else if (pos >= count) 
        {
            tail.next = n;
            n.prev = tail;
            tail = n;
        } 
        else 
        {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            n.next = temp.next;
            n.prev = temp;
            temp.next.prev = n;
            temp.next = n;
        }
        count++;
    }
}
