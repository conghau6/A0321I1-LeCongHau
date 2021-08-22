package _17_binary_file.bai_tap.ql_san_pham;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int maSp;
    private String tenSp;
    private String hangSx;
    private double gia;
    private String moTa;

    public SanPham() {
    }

    public SanPham(int maSp, String tenSp, String hangSx, double gia, String moTa) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.hangSx = hangSx;
        this.gia = gia;
        this.moTa = moTa;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getHangSx() {
        return hangSx;
    }

    public void setHangSx(String hangSx) {
        this.hangSx = hangSx;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return maSp + "-" + tenSp + "-" + hangSx + "-" + gia + "-" + moTa;
    }
}
