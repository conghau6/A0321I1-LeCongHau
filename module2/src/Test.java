import java.util.*;

public class Test {
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
    }
}
