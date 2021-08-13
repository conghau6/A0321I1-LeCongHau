package _15_exception.thuc_hanh.numberformatexception;

public class CalculationExample {
    public void calculate(int x, int y){
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e){
            System.err.println("Xảy ra ngoại lệ " + e.getMessage());
        }
    }
}
