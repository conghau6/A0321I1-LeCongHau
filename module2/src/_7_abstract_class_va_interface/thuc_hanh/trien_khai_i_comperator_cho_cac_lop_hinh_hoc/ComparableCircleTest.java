package _7_abstract_class_va_interface.thuc_hanh.trien_khai_i_comperator_cho_cac_lop_hinh_hoc;

import _6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Circle;


public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        for(int i=0; i<circles.length-1; i++){
            for(int j=1; j<circles.length; j++){
                if(circles[i].getRadius() < circles[j].getRadius()){
                    Circle x = circles[i];
                    circles[i] = circles[j];
                    circles[j] = (ComparableCircle) x;
                }
            }
        }
        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
