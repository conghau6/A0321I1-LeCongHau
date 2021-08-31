package CaseStudy.models;

public class Promotion {
    private Booking booking;
    private String voucher;

    public Promotion() {
    }

    public Promotion(Booking booking, String voucher) {
        this.booking = booking;
        this.voucher = voucher;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "booking=" + booking +
                ", voucher='" + voucher + '\'' +
                '}';
    }
}
