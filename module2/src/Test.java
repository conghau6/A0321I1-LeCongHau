

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int x = 0;
        Scanner scanner = new Scanner(System.in);


        boolean loi = false;
        do {

            try {
                System.out.print("Nhập 1 số: ");
                x = Integer.parseInt(scanner.nextLine());
                loi = false;
            } catch (Exception e) {
                System.out.println("lỗi, nhập lại");
                loi = true;
            }
        } while (loi);
        System.out.println(x);
    }
}
