package cedic.asm1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float[] inputArr;
        float[] initialArr = null;
        int choice = -1;
        float searchValue;
        double start, end;


        while(true) {
            System.out.println("* * * * * * * * * *     Menu      * * * * * * * * *");
            System.out.printf("%-20s%-30s%s","*","1.Input","*\n");
            System.out.printf("%-20s%-30s%s","*","2.Output","*\n");
            System.out.printf("%-20s%-30s%s","*","3.Bubble sort","*\n");
            System.out.printf("%-20s%-30s%s","*","4.Selection sort","*\n");
            System.out.printf("%-20s%-30s%s","*","5.Insertion sort","*\n");
            System.out.printf("%-20s%-30s%s","*","6.Search > value","*\n");
            System.out.printf("%-20s%-30s%s","*","7.Search = value","*\n");
            System.out.printf("%-20s%-30s%s","*","0.Exit","*\n");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * ");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ex) {
                sc.nextLine();
            }

            switch(choice){
                case 1:
                    inputArr = Algorithm.takeInput();
                    Algorithm.writeFile(inputArr, "input.txt", false);
                    break;
                case 2:
                    try {
                        System.out.println("Read from file");
                        System.out.println("Initial Arr: ");
                        initialArr = Algorithm.readFile();
                    } catch (FileNotFoundException ex) {
                        System.out.println("\nFile not found! Please choose number 1 first.");
                    } catch (IOException ex) {
                        Logger.getLogger(MainSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 3:
                    try {
                        float[] bubbleSortArr = new float[initialArr.length];
                        System.out.println("Bubble sort progress: ");
                        System.arraycopy(initialArr, 0, bubbleSortArr, 0, initialArr.length);
                        start = System.currentTimeMillis();
                        Algorithm.bubbleSort(bubbleSortArr, true);
                        end = System.currentTimeMillis();
                        System.out.println("Bubble Sort time: " + (end-start) +" ms");
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                    }
                    break;
                case 4:
                    try {
                        float[] selectSortArr = new float[initialArr.length];
                        System.out.println("Selection sort progress: ");
                        System.arraycopy(initialArr, 0, selectSortArr, 0, initialArr.length);
                        start = System.currentTimeMillis();
                        Algorithm.selectSort(selectSortArr, true);
                        end = System.currentTimeMillis();
                        System.out.println("Selection Sort time: " + (end-start) +" ms");
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                    }
                    break;
                case 5:
                    try {
                        float[] insertSortArr = new float[initialArr.length];
                        System.out.println("Insertion sort progress: ");
                        System.arraycopy(initialArr, 0, insertSortArr, 0, initialArr.length);
                        start = System.currentTimeMillis();
                        Algorithm.insertSort(insertSortArr, true);
                        end = System.currentTimeMillis();
                        System.out.println("Insertion Sort time: " + (end-start) +" ms");
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                    }
                    break;
                case 6:
                    System.out.println("Linear search: ");
                    System.out.print("Search value: ");
                    searchValue = sc.nextFloat();
                    System.out.print("Index: ");
                    try {
                        Algorithm.search(initialArr, searchValue);
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                    }
                    break;
                case 7:
                    System.out.println("Binary search: ");
                    System.out.print("Search value: ");
                    searchValue = sc.nextFloat();
                    System.out.print("Index: ");
                    try {
                        Algorithm.binarySearch(initialArr, searchValue);
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                    }
                    break;
                case 0:
                    System.out.println("Bye for now!");
                    break;
                default:
                    System.out.println("Please choose again");
            }
        }
    }

}