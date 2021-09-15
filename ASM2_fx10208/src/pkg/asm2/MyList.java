package pkg.asm2;

public class MyList {
    Node head;
    Node tail;

    // Thêm vào cuối LinkedList
    public void insertAtTail(Product item) {
        Node newNode = new Node(item);

        if (this.head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    // Hoán đổi vị trí hai node
    public void swap(Node left, Node right) {
        Product temp;
        temp = left.info;
        left.info = right.info;
        right.info = temp;
    }

    // Sắp xếp theo ID sử dụng đệ quy
    public void sortById(MyList myList, Node current) {

        if (current.nextNode == null) {
            return;
        }
        Node nxNode = current.nextNode;
        while (nxNode != null) {
            if (nxNode.info.id.compareToIgnoreCase(current.info.id) < 0) {
                myList.swap(nxNode, current);
            }
            nxNode = nxNode.nextNode;
        }


        // Đệ quy gọi lại chính nó trong hàm
        sortById(myList, current.nextNode);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID\t\t\t|\t\t").append("Name\t\t|\t").append("Quanlity\t|\t").append("Price").append("\n");
        Node current = this.head;

        while (current != null) {
            result.append(current.toString()).append(" ").append("\n");
            current = current.nextNode;
        }
        return result.toString();
    }
}
