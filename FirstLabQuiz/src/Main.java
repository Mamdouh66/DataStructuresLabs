
public class Main {
    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();

        System.out.println();

        linkedList.add(-2);
        linkedList.add(-4);
        linkedList.add(-6);
        linkedList.add(-8);
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(11);
        linkedList.printList();
        linkedList.lock();
        linkedList.add(11);
        linkedList.add(12);
        linkedList.unlock();
        linkedList.remove();
        linkedList.add(11);
        linkedList.printList();

    }
}

class CircularLinkedList {
    private Node head;
    private Node tail;
    class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isLocked;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.isLocked = false;
        this.size = 0;
    }

    public void add(int data) {
        if (isLocked) {
            System.out.println("The linked list is locked; you must remove the locking before adding");
            return;
        }
        if (data < 0) {
            System.out.println("The linked list cannot accept negative values");
            return;
        }
        if (size >= 5) {
            System.out.println("The linked list cannot accept more than five nodes");
            return;
        }
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void remove() {
        if (isLocked) {
            System.out.println("The linked list is locked; you must remove the locking before removing");
            return;
        }
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        System.out.println("The head value successfully removed.");
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
        Node currentNode = head;
        int i = 0;
        do {
            i++;
            System.out.println("Node "+ i + ": "+ currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != head);
        System.out.println();
    }
}
