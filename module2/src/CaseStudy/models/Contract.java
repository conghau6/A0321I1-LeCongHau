package CaseStudy.models;

public class Contract {
    private int id;
    private Booking booking;
    private double tienCocTruoc;
    private double tongChiPhi;
    private int maKhachHang;

    public Contract() {
    }

    public Contract(int id, Booking booking, double tienCocTruoc, double tongChiPhi, int maKhachHang) {
        this.id = id;
        this.booking = booking;
        this.tienCocTruoc = tienCocTruoc;
        this.tongChiPhi = tongChiPhi;
        this.maKhachHang = maKhachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getTienCocTruoc() {
        return tienCocTruoc;
    }

    public void setTienCocTruoc(double tienCocTruoc) {
        this.tienCocTruoc = tienCocTruoc;
    }

    public double getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(double tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", booking=" + booking +
                ", tienCocTruoc=" + tienCocTruoc +
                ", tongChiPhi=" + tongChiPhi +
                ", maKhachHang=" + maKhachHang +
                '}';
    }
}
