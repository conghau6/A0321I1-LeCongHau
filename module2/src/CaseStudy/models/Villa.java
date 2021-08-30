package CaseStudy.models;

public class Villa extends Facility {
    private String tieuChuanPhong;
    private double dtHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String tenDv, double dtSd, double phiThue, int soNgToiDa, String kieuThue, String tieuChuanPhong, double dtHoBoi, int soTang) {
        super(tenDv, dtSd, phiThue, soNgToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.dtHoBoi = dtHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public double getDtHoBoi() {
        return dtHoBoi;
    }

    public void setDtHoBoi(double dtHoBoi) {
        this.dtHoBoi = dtHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", dtHoBoi=" + dtHoBoi +
                ", soTang=" + soTang +
                ", tenDv='" + tenDv + '\'' +
                ", dtSd='" + dtSd + '\'' +
                ", phiThue=" + phiThue +
                ", soNgToiDa=" + soNgToiDa +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }
}
