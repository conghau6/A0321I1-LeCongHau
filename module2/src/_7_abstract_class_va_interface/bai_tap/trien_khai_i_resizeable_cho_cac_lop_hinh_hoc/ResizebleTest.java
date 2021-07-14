package _7_abstract_class_va_interface.bai_tap.trien_khai_i_resizeable_cho_cac_lop_hinh_hoc;

public class ResizebleTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 5);
        shapes[2] = new Square(5);

        System.out.println("Original Area");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }

        //Tăng diện tích tất cả các hình lên 20%
        for (Shape shape : shapes) {
            shape.resize(20);
        }

        System.out.println("After Increase");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
