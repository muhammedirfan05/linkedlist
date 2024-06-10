import java.util.*;

public class SinglySwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList2 l = new LinkedList2();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        System.out.println("Original List:");
        l.display();
        l.swapAdjacentNodes();
        System.out.println("\nList after swapping adjacent nodes:");
        l.display();
        sc.close();
    }
}

class LinkedList2 {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void swapAdjacentNodes() {
        Node current = head;
        if (current == null || current.next == null) 
        {
            return;
        }
        while (current != null && current.next != null) 
        {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }
}
