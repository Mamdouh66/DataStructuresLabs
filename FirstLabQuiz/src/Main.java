
public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        System.out.println();

        // Adding negative values
        list.add(-2);
        list.add(-4);
        list.add(-6);
        list.add(-8);
        System.out.println();

        // Adding positive values
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);

        // Trying to add more than five values
        list.add(11);

        System.out.println();
        // Print the linked list
        list.printList();

        // Locking the list
        list.lock();

        // Trying to add when locked
        list.add(11);
        list.add(12);
        System.out.println();

        // Unlocking list
        list.unlock();

        // Removing head
        list.remove();

        // Adding new element
        list.add(11);

        // Locking the list
        list.printList();

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
            System.out.println("The linked list cannot accept negative values [" + data +"]");
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
