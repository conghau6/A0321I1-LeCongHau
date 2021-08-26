import java.util.*;

public class Test {
    public static void nhapSo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập 1 số: ");
        int x = scanner.nextInt();
        System.out.println(x);
    }
    public static void main(String[] args) {
        boolean check = true;
        do {
            try {
                nhapSo();
            } catch (InputMismatchException exception) {
                System.out.println("Nhập sai");
                check = false;
            } catch (Exception exception) {
                check = false;
            }
        }while (check == false);
    }
}
