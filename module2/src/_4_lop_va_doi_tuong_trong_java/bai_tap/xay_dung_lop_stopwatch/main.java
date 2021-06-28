package _4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_stopwatch;

public class main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        long x=0;
        for(long i=0; i<=1000000; i++){
            x*=x;
        }
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
