import java.util.*;

public class Test {
    public static int tongNgay(String ngay) {
        int d = Integer.parseInt(String.valueOf(ngay.charAt(0))) + Integer.parseInt(String.valueOf(ngay.charAt(1)));
        int m = Integer.parseInt(String.valueOf(ngay.charAt(3))) + Integer.parseInt(String.valueOf(ngay.charAt(4)));
        int y = Integer.parseInt(String.valueOf(ngay.charAt(8))) + Integer.parseInt(String.valueOf(ngay.charAt(9)));
        return d + m*12 + y;
    }
    public static void main(String[] args) {
        Map<Integer, String> listSv = new LinkedHashMap<>();
        listSv.put(1,"Lê Công Hậu");
        listSv.put(2, "Hậu công lê");

        for(Map.Entry<Integer, String> sv : listSv.entrySet()) {
            System.out.println(sv);
        }

//        Set<Integer> keySet = listSv.keySet();
        List<Integer> keyArr = new ArrayList<>(listSv.keySet());


        for(int i=0; i<keyArr.size(); i++){
            System.out.println(keyArr.get(i));
        }

        System.out.println(tongNgay("01/01/2001"));
    }
}
