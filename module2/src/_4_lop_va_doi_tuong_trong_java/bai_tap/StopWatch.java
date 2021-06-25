package _4_lop_va_doi_tuong_trong_java.bai_tap;

public class StopWatch {
    private long startTime, endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public StopWatch(){
        startTime = System.currentTimeMillis();
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void end(){
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime - startTime;
    }
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
