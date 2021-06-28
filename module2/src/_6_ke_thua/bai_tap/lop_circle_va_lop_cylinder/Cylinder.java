package _6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle {
    private double hight = 1.0;

    public Cylinder() {
        super();
    }

    public Cylinder(double radius, String color, double hight) {
        super(radius, color);
        this.hight = hight;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double geVolume() {
        return Math.PI * hight * getRadius() * getRadius();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "hight=" + hight +
                ", radius=" + getRadius() +
                ", color='" + getColor() +
                ", volume='" + geVolume() + '\'' +
                '}';
    }

}
