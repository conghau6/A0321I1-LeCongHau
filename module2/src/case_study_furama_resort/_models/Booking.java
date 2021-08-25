package case_study_furama_resort._models;

public class Booking implements Comparable <Booking> {
    private int maBooking;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int maKachHang;
    private String tenDv;
    private String loaiDv;

    public Booking() {
    }

    public Booking(int maBooking, String ngayBatDau, String ngayKetThuc, int maKachHang, String tenDv, String loaiDv) {
        this.maBooking = maBooking;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maKachHang = maKachHang;
        this.tenDv = tenDv;
        this.loaiDv = loaiDv;
    }

    public int getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(int maBooking) {
        this.maBooking = maBooking;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMaKachHang() {
        return maKachHang;
    }

    public void setMaKachHang(int maKachHang) {
        this.maKachHang = maKachHang;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public String getLoaiDv() {
        return loaiDv;
    }

    public void setLoaiDv(String loaiDv) {
        this.loaiDv = loaiDv;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking=" + maBooking +
                ", ngayBatDau='" + ngayBatDau + '\'' +
                ", ngayKetThuc='" + ngayKetThuc + '\'' +
                ", maKachHang=" + maKachHang +
                ", tenDv='" + tenDv + '\'' +
                ", loaiDv='" + loaiDv + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        return this.getTenDv().compareTo(o.getTenDv());
    }
}
