package _5_access_modifier_static_method_static_property.bai_tap._access_modifier;

public class Circle {
    private double radius;
    private String color;
    public Circle(){
        radius = 1.0;
        color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        color = "red";
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return radius*radius;
    }
}
