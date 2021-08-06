package _13_thuat_toan_tim_kiem.bai_tap.tim_chuoi_tang_dan_lon_nhat;

import java.util.LinkedList;

public class MaxString {
    public String maxString(String string) {
        String result = "";
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for(Character ch: max) {
            result += ch;
        }
        return result;
    }
}
