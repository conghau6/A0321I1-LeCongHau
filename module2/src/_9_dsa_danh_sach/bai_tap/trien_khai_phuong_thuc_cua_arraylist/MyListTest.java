package _9_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> a = new MyList<Integer>();
        a.add(1);
        a.add(213);
        a.add(432,1);
        System.out.println(a.size());
        for(int i=0; i<a.size(); i++){
            System.out.println(a.get(i));
        }
        a.clear();
    }
}
