package _15_exception.thuc_hanh.arrindexoutofboundexception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập chỉ số của 1 phần tử bất kỳ: ");
        int x = scanner.nextInt();

        try {
            System.out.println("Giá trị phần tử có chỉ số " + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }
}
