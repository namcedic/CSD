package pkg.asm2;

public class Node  {
    Node nextNode;
    Product info;


    public Node (Product product, Node node) {
        info =  product;
        nextNode = node;
    }


    public Node(Product item) {
        this(item, null);
    }

    public Node() {}


    @Override
    public String toString() {
        return info.id + "\t\t|\t\t" + info.name + "\t\t|\t\t" + info.quantity + "\t\t|\t" + info.price;
    }
}