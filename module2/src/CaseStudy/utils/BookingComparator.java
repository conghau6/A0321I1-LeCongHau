package CaseStudy.utils;

import CaseStudy.models.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDay1 = LocalDate.parse(o1.getNgayBd(), formatter);
        LocalDate startDay2 = LocalDate.parse(o1.getNgayBd(), formatter);
        LocalDate endDay1 = LocalDate.parse(o1.getNgayKt(), formatter);
        LocalDate endDay2 = LocalDate.parse(o1.getNgayKt(), formatter);

        if(startDay1.compareTo(startDay2) > 0){
            return 1;
        } else if(startDay1.compareTo(startDay2) < 0) {
            return -1;
        } else {
            if(endDay1.compareTo(endDay2) > 0){
                return 1;
            } else if(endDay1.compareTo(endDay2) < 0){
                return -1;
            } else {
                return 0;
            }
        }
    }
}
