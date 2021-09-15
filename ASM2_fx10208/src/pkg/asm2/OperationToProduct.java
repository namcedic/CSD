package pkg.asm2;

import java.io.*;
import java.util.Scanner;

public class OperationToProduct {

    private static final String FILE_NAME = "C:\\Users\\leena\\IdeaProjects\\ASM2_fx10208\\data.txt";

    private static final String OUT_PUT = "C:\\Users\\leena\\IdeaProjects\\ASM2_fx10208\\console_output.txt";

    // Thêm một số sản phẩm vào LinkedList
    public static void productData(MyList myList) throws IOException {
        Product product = new Product("PD01", "Bread", 2, 18);
        Product product1 = new Product("PD12", "Milk", 5, 6);
        Product product2 = new Product("PD05", "Lemon", 35, 2);
        Product product3 = new Product("PD22", "Coffee", 9, 9);
        Product product4 = new Product("PD08", "Soda", 55, 15);
        Product product5 = new Product("PD06", "Pepsi", 65, 22);

        myList.insertAtTail(product);
        myList.insertAtTail(product1);
        myList.insertAtTail(product2);
        myList.insertAtTail(product3);
        myList.insertAtTail(product4);
        myList.insertAtTail(product5);

        // Lưu vào file
        writeFile(FILE_NAME, myList);
        System.out.println(myList);
    }

    // Thêm sản phẩm vào cuối LinkedList
    public static void addProduct(MyList myList) {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.print("ID: ");
            String id = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            // Lấy dữ liệu nhập, và sản phẩm lưu vào LinkedList
            Product product = new Product(id, name, quantity, price);
            myList.insertAtTail(product);
            System.out.println("Successfully!");

            System.out.println("Continue?: 1-Yes | 2-No");
            input = Integer.parseInt(sc.nextLine());
        } while (input != 2);
    }

    //Hiển thị thông tin sản phẩm từ LinkedList
    public static void displayProductInfo(MyList myList) throws IOException {
        System.out.println(myList);
        writeFile(OUT_PUT, myList);
    }
    // Ghi dữ liệu dạng object vào file
    public static <T> void writeFile(String fileName, T data) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(String.valueOf(data));

        printWriter.close();
        fileWriter.close();
    }

    public static void addToFile(MyList myList) throws IOException {
        writeFile(FILE_NAME, myList);
        System.out.println("Successfully!");
    }

    // Tìm kiếm thông tin sản phẩm theo ID
    public static void searchById(MyList myList) {
        Scanner sc = new Scanner(System.in);

        Node current = myList.head;
        System.out.print("ID: ");
        String key = sc.next();
        Node nxNode = current.nextNode;

        // Nếu tù khóa trùng với Node đầu tiên in Node và thoát
        while (current != null) {
            // Ở lần lặp tiếp theo điều kiện sẽ false, chương trình sẽ nhảy xuống vòng lặp bên dưới
            if (current.info.id.equalsIgnoreCase(key)) {
                System.out.println("Successfully!");
                System.out.println(current);
                return;
            }

            // nxNode là một node sau head duyệt qua và tìm node trùng với key
            while (nxNode != null && nxNode.info.id.equalsIgnoreCase(key)) {
                System.out.println("Successfully!");
                System.out.println(nxNode);
                return;
            }
            // cập nhật current là nốt tiếp theo
            current = current.nextNode;
        }
        // Vòng lặp sẽ chạy đến khi current = null nếu không tìm thấy key trùng

        System.out.println("Not Found: -1");
    }

    //Delete product (ID)
    public static void deleteById(MyList myList) {

        Scanner sc = new Scanner(System.in);
        Node current = myList.head;
        Node newNode = null;

        System.out.print("ID: ");
        String key = sc.next();

        // Nếu Id Node head giống với từ khóa thì xóa head
        if (current != null && current.info.id.equalsIgnoreCase(key)) {
            myList.head = current.nextNode;
            System.out.println("Deleted!");
            return;
        }

        while (current != null && !(current.info.id.equalsIgnoreCase(key))) {

            newNode = current;
            current = current.nextNode;
        }
        newNode.nextNode = current.nextNode;

        /**
         * Trỏ lại tail khi xóa phần tử cuối cùng
         */

        if(current.nextNode==null) {
            myList.tail=newNode;
        }
        System.out.println("Deleted!");
    }

    // Chuyển sang hệ nhị phân
    public static int convertBinary(int quantity) {
        if (quantity == 0) {
            return 0;
        }
        return (quantity % 2 + 10 * convertBinary(quantity / 2));
    }

    // Lưu file vào stack
    public static void savetoStack() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReader(FILE_NAME);

        int i;
        // Trong khi vẫn còn đọc danh sách
        while ((i = fileReader.read()) != -1) {

            //Nối chuỗi với mã đc ép kiểu sang char
            sb.append((char) i);
        }
        fileReader.close();
        String arrString = sb.toString();

        // Tách chuổi thành từng dòng thông qua điểm chung \n
        String[] arr = arrString.split("\n");
        MyStack myStack = new MyStack();
        int n = arr.length;

        // Duyệt qua mảng tách để lấy những thuộc tính riêng
        for (int j = 1; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            myStack.pushStackHead(product);
        }
        System.out.print(myStack);

        // Ghi vào file
        writeFile(OUT_PUT, myStack);
    }

    // Lưu file vào queue
    public static void saveToQueue() throws IOException {
        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(FILE_NAME);

        int i;
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }
        fileReader.close();

        String arrString = sb.toString();
        String[] arr = arrString.split("\n");
        MyQueue myQueue = new MyQueue();
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            String[] str = arr[j].split("\\|");
            Product product = new Product(str[0], str[1], Integer.parseInt(str[2].trim()), Double.parseDouble(str[3].trim()));
            myQueue.enQueue(product);
        }
        System.out.print(myQueue);
        writeFile(OUT_PUT, myQueue);
    }
}