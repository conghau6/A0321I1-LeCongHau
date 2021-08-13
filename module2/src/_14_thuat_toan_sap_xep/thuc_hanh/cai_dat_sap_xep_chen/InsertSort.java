package _14_thuat_toan_sap_xep.thuc_hanh.cai_dat_sap_xep_chen;

public class InsertSort {
    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
