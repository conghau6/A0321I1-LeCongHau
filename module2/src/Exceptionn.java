import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptionn {
    public static void checkAge() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        if(y<0) throw new Exception("Không được nhập số âm");
    }

    public static void main(String[] args) {
        try {
            checkAge();
        } catch (InputMismatchException e){
            System.err.println("SỐ vừa nhập là chữ");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
