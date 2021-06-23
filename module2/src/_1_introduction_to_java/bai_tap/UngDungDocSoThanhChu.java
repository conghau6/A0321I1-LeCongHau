package _1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    final static String[] ONES = {""," one"," two"," three"," four"," five", " six", " seven"
        ," eight", " nine"," ten"," eleven", " twelve"," thirteen", " fourteen", " sixteen"
        ," seventeen"," eighteen"," nineteen"};
    public static String[] TENS = {" "," "," twenty"," thirty"," forty", " fifty"," sixty"," seventy"
    ," eighty", " ninety"};

    public static void readNumber(int num, String value){
        System.out.println(num>19?TENS[num/10]+" "+ONES[num%10]:ONES[num]);
        System.out.println(num>0?value:"");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        readNumber(((num/10)%10)," hundred and" );
        readNumber(num%10,"");
    }
}
