package pkg.asm2;

public class Product  {
    public String name;
    public String id;
    public double price;
    public int quantity;



    public Product(String id, String name, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t|\t" + name + "\t|\t" + quantity + "\t|\t" + price;

    }
}