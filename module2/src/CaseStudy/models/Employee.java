package CaseStudy.models;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private String trinhDo;
    private String viTri;
    private double luong;

    public Employee() {
    }

    public Employee(int id, String ten, String ngaySinh, String gioiTinh, String cmnd, String sdt, String email, String trinhDo, String viTri, double luong) {
        super(id, ten, ngaySinh, gioiTinh, cmnd, sdt, email);
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "trinhDo='" + trinhDo + '\'' +
                ", viTri='" + viTri + '\'' +
                ", luong=" + luong +
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
