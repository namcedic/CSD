package cedic.asm1;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Algorithm {

    public Algorithm() {
    }



    // Hiển thị mảng dưới dạng chuỗi
    public static void display(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    // Nhập vào 1 mảng với các giá trị, được dùng cho các chức năng bên dưới.

    public static float[] takeInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of elements: ");
        int len = 0;
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                len = input.nextInt();
                input.nextLine();
                break;
            } else {
                input.nextLine();
                System.out.print("Please input a number: ");
            }
        }
        float[] userArr = new float[len];
        for (int i = 0; i < len; i++) {
            System.out.print("number " + (i + 1) + ": ");
            while (input.hasNext()) {
                if (input.hasNextFloat() || input.hasNextInt()) {
                    userArr[i] = input.nextFloat();
                    input.nextLine();
                    break;
                } else {
                    input.nextLine();
                    System.out.print("Please input a number: ");
                }
            }
        }
        return userArr;
    }
    // Ghi 1 mảng vào tệp, append để ghi đè.

    public static void writeFile(float[] userArr, String path, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (float numberItem : userArr) {
                bw.write(numberItem + "\t");
            }
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Ghi 1 mảng dạng chuỗi vào tệp, append để ghi đè.

    public static void writeFile(String[] userArr, String path, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (String numberItem : userArr) {
                bw.write(numberItem + "\t");
            }
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Đọc tệp tin và hiển thị thông tin, ném ra ngoại lệ nếu không tìm thấy tệp.

    public static float[] readFile() throws FileNotFoundException, IOException {
        String[] holderArray;
        float[] finalArray;
        try (FileReader fr = new FileReader("input.txt")) {
            Scanner reader = new Scanner(fr);
            holderArray = reader.nextLine().split("\t");
            finalArray = new float[holderArray.length];
            for (int i = 0; i < holderArray.length; i++) {
                finalArray[i] = Float.parseFloat(holderArray[i]);
            }
        }
        display(finalArray);
        return finalArray;
    }

    public static void swap(int i, int k, float[] arr) {
        float x;
        x = arr[i];
        arr[i] = arr[k];
        arr[k] = x;
    }

    /*Sắp xếp nổi bọt, ghi vào file output1.txt
    thuật toán này có thời gian sắp xếp chậm nhất
    displaySteps là lựa chọn hiển thị tiến trình sắp xếp
    */

    public static void bubbleSort(float[] sorting, boolean displaySteps) {
        for (int i = 0; i < sorting.length - 1; i++) {
            for (int j = 0; j < sorting.length - 1 - i; j++) {
                if (sorting[j] > sorting[j + 1]) {
                    swap(j, j + 1, sorting);
                }
            }
            if (displaySteps) {
                display(sorting);
            }
            if (i == 0) {
                writeFile(sorting, "output1.txt", false);
            } else {
                writeFile(sorting, "output1.txt", true);
            }
        }
    }

     /*Sắp xếp lựa chọn, ghi vào file output2.txt
     thời gian sắp xếp nhanh
     displaySteps là lựa chọn hiển thị tiến trình sắp xếp
     */

    public static void selectSort(float[] sorting, boolean displaySteps) {
        for (int i = 0; i < sorting.length - 1; i++) {
            var minPosition = i;
            for (int j = i + 1; j < sorting.length; j++) {
                if (sorting[j] < sorting[minPosition]) {
                    minPosition = j;
                }
            }
            if (minPosition != i) {
                swap(minPosition, i, sorting);
            }
            if (displaySteps) {
                display(sorting);
            }
            if (i == 0) {
                writeFile(sorting, "output2.txt", false);
            } else {
                writeFile(sorting, "output2.txt", true);
            }
        }
    }
    /* Với Dữ liệu sắp xếp theo thứ tự ngược lại hiệu năng của 3 thuật toán là như nhau do đây là trường hợp xấu nhất
    với cả 3 thuật toán O(n2);
    * Với Dữ liệu đã được sắp xếp thì hiệu năng của BubbleSort và InsertSort là tốt nhất
    O(n) và của Select Sort là kém nhất O(n2) chênh lệch nhiều hơn Dữ liệu có xáo trộn ngẫu nhiên ;
    * Với Dữ liệu có xáo trộn ngẫu nhiên thì hiệu năng của BubbleSort và InsertSort là tốt nhất
    O(n2) và của Select Sort là kém nhất O(n2) nhưng chênh lệch không nhiều do có thể 1 dữ liệu đã được sắp xếp;
    */

    /*Sắp xếp chèn, ghi vào file output3.txt
    displaySteps là lựa chọn hiển thị tiến trình xắp xếp
     */
    public static void insertSort(float[] sorting, boolean displaySteps) {
        for (int i = 1; i < sorting.length; i++) {
            int current = i;
            float valueInsert = sorting[i];
            while (current > 0 && sorting[current - 1] > valueInsert) {
                sorting[current] = sorting[current - 1];
                current--;
            }
            sorting[current] = valueInsert;
            if (displaySteps) {
                display(sorting);
            }
            if (i == 1) {
                writeFile(sorting, "output3.txt", false);
            } else {
                writeFile(sorting, "output3.txt", true);
            }
        }
    }

     // Tìm kiếm tuyến tính theo giá trị nhập, ghi vào file output4.txt

    public static void search(float[] arr, float searchValue) {
        String found = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= searchValue) {
                found = found.concat(i + "\t");
            }
        }
        if (!found.isEmpty()) {
            System.out.println(found);
            String[] foundArr = found.split("\t");
            writeFile(foundArr, "output4.txt", false);
        } else {
            String[] notFound = {"Nothing found"};
            System.out.println("Nothing found");
            writeFile(notFound, "output4.txt", false);
        }
    }

    // Tìm kiếm nhị phân trên mảng đã xắp xếp và ghi thông tin vào tệp output5.txt, không hiển thị xắp xếp

    public static int binarySearch(float[] arr, float searchValue) {
        selectSort(arr, false);
        int lower = 0;
        int upper = arr.length;
        int midPoint;
        do {
            if (upper < lower) {
                break;
            }
            midPoint = lower + (upper - lower) / 2;
            if (arr[midPoint] > searchValue) {
                upper = midPoint - 1;
            }
            if (arr[midPoint] < searchValue) {
                lower = midPoint + 1;
            }
            if (searchValue == arr[midPoint]) {
                String[] foundArr = {(midPoint + "\t")};
                System.out.println(midPoint);
                writeFile(foundArr,"output5.txt", false);
                return midPoint;
            }
        } while (searchValue != arr[midPoint]);
        String[] notFound = {"Nothing found"};
        System.out.println("Nothing found");
        writeFile(notFound, "output5.txt", false);
        return -1;
    }
    
}