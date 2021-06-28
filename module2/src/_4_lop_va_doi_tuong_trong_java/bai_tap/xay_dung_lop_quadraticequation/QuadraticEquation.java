package _4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_quadraticequation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
        this.a = this.b = this.c = 0;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-b + Math.sqrt(getDiscriminant()) / 2 / this.a);
    }

    public double getRoot2() {
        return (-b - Math.sqrt(getDiscriminant()) / 2 / this.a);
    }

    public String getResult() {
        if (getDiscriminant() < 0) return "The equation has no root";
        else if (getDiscriminant() == 0) return "One root: " + getRoot1();
        else return "Two root: " + getRoot1() + " and " + getRoot2();
    }

    public String toString() {
        return "QuadraticEquation{" + this.a + "," + this.b + "," + this.c + "}" + " " + getResult();
    }
}
