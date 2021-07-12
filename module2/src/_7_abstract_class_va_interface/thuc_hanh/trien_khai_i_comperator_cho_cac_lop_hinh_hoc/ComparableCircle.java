package _7_abstract_class_va_interface.thuc_hanh.trien_khai_i_comperator_cho_cac_lop_hinh_hoc;

import _6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Circle;

public class ComparableCircle extends Circle {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
