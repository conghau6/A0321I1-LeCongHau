package _7_abstract_class_va_interface.bai_tap.trien_khai_i_colorable_cho_cac_lop_hinh_hoc;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 5);
        shapes[2] = new Square(5);

        for (Shape shape : shapes) {
            System.out.print(shape.getArea() + " ");
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            } else {
                System.out.println();
            }
        }
    }
}
