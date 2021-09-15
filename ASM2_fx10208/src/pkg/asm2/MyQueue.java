package pkg.asm2;

public class MyQueue {
    Node head, tail;
    int size;


    public void myQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    // Thêm Node vào Queue
    public void enQueue(Product item) {
        Node current = tail;
        tail = new Node();
        tail.info = item;
        tail.nextNode = null;
        if (isEmpty()) {
            head = tail;
        } else {
            current.nextNode = tail;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID\t\t\t\t\t|\t\t\t\t").append("Name\t\t\t\t|\t").append("Quanlity\t|\t").append("Price").append("\n");

        Node current = head;
        while (current != null) {
            result.append(current.toString()).append(" ").append("\n");
            current = current.nextNode;
        }
        return result.toString();
    }
}