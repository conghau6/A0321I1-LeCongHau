package CaseStudy.models;

public class Booking {
    private int maBooking;
    private String ngayBd;
    private String ngayKt;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(int maBooking, String ngayBd, String ngayKt, Customer customer, Facility facility) {
        this.maBooking = maBooking;
        this.ngayBd = ngayBd;
        this.ngayKt = ngayKt;
        this.customer = customer;
        this.facility = facility;
    }

    public int getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(int maBooking) {
        this.maBooking = maBooking;
    }

    public String getNgayBd() {
        return ngayBd;
    }

    public void setNgayBd(String ngayBd) {
        this.ngayBd = ngayBd;
    }

    public String getNgayKt() {
        return ngayKt;
    }

    public void setNgayKt(String ngayKt) {
        this.ngayKt = ngayKt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking=" + maBooking +
                ", ngayBd='" + ngayBd + '\'' +
                ", ngayKt='" + ngayKt + '\'' +
                ", customer=" + customer +
                ", facility=" + facility +
                '}';
    }
}
