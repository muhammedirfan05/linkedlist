import java.util.*;

public class SinglyRotate {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        l.add(10);
        l.add(20);
        l.add(30);
        l.display();
        l.rotateLeft(4);
        l.display();
        l.rotateRight(2);
        l.display();
        sc.close();
    }
}
class LinkedList {
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
    public void rotateLeft(int k) {
        k %= count;
        if (k == 0) 
            return;
        Node temp = head;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        tail.next = head;
        head = temp.next;
        temp.next = null;
    }
    public void rotateRight(int k) {
        k %= count; 
        if (k == 0) return; 
        Node temp = head;
        for (int i = 0; i < count - k - 1; i++) {
            temp = temp.next;
        }
        tail.next = head;
        head = temp.next;
        temp.next = null;
    }
}
