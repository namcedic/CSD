package pkg.asm2;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        MyList myList = new MyList();

        boolean choice = true;
        do {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*          Product List                                 *");
            System.out.println("*          1. Load data from file and display           *");
            System.out.println("*          2. Input & add to the end.                   *");
            System.out.println("*          3. Display data                              *");
            System.out.println("*          4. Save product list to file                 *");
            System.out.println("*          5. Search by ID                              *");
            System.out.println("*          6. Delete by ID                              *");
            System.out.println("*          7. Sort by ID                                *");
            System.out.println("*          8. Convert to binary                         *");
            System.out.println("*          9. Load to Stack and display                 *");
            System.out.println("*          10. Load to Queue and display                *");
            System.out.println("*          0. Exit                                      *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.print("Your choice: ");

            try {
                int input = Integer.parseInt(sc.nextLine());

                switch (input) {
                    case 1:
                        System.out.println("List from file");
                        OperationToProduct.productData(myList);
                        break;
                    case 2:
                        System.out.println("Adding product");
                        OperationToProduct.addProduct(myList);
                        break;
                    case 3:
                        System.out.println("List of product");
                        OperationToProduct.displayProductInfo(myList);
                        break;
                    case 4:
                        System.out.println("Saving to file");
                        OperationToProduct.addToFile(myList);
                        break;
                    case 5:
                        System.out.println("Search by ID");
                        OperationToProduct.searchById(myList);
                        break;
                    case 6:
                        System.out.println("Delete by ID");
                        OperationToProduct.deleteById(myList);
                        break;
                    case 7:
                        System.out.println("Sort by ID");
                        myList.sortById(myList, myList.head);
                        System.out.println(myList);
                        break;
                    case 8:
                        System.out.printf("Binary of %d: ", myList.head.info.quantity);
                        System.out.println(OperationToProduct.convertBinary(myList.head.info.quantity));
                        break;
                    case 9:
                        System.out.println("Load to stack and display");
                        OperationToProduct.savetoStack();
                        break;
                    case 10:
                        System.out.println("Load to queue and display");
                        OperationToProduct.saveToQueue();
                        break;
                    default:
                        choice = false;
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        } while (choice);
    }
}