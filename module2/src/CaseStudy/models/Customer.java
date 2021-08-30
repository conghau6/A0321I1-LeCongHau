package CaseStudy.models;

public class Customer extends Person {
    private String loaiKhach;
    private String diaChi;

    public Customer() {
    }

    public Customer(int id, String ten, String ngaySinh, String gioiTinh, String cmnd, String sdt, String email, String loaiKhach, String diaChi) {
        super(id, ten, ngaySinh, gioiTinh, cmnd, sdt, email);
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", id=" + id +
                ", ten='" + ten + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
