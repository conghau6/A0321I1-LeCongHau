package Demo;

public class Main {
    public static void suaAge (int x) {
        x = 40;
    }

    public static void main(String[] args) {
        SinhVien a = new SinhVien("hau",19);
        SinhVien b = a;
        suaAge(b.getAge());
        System.out.println(a);
        System.out.println(b);
    }
}
