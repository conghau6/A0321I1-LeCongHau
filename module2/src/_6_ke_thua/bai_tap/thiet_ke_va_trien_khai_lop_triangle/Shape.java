package _6_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Shape {
    private String color = "red";

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor();
    }
}
