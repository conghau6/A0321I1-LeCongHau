package _14_thuat_toan_sap_xep.thuc_hanh.minh_hoa_sap_xep_noi_bot;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        boolean isSwap = true;
        for (int i = 0; i < arr.length - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }
        }
    }
}
