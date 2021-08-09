package _15_thuat_toan_sap_xep.thuc_hanh.minh_hoa_sap_xep_noi_bot;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,76,22,34,5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
