package _7_abstract_class_va_interface.bai_tap.trien_khai_i_resizeable_cho_cac_lop_hinh_hoc;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ",which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(Math.sqrt(getRadius() * getRadius() * (1 + percent / 100)));
        //khi tăng diện tích lên x% thì bán kính sẽ tăng căn (r1^2 * (1+x/100)) lần
    }
}
