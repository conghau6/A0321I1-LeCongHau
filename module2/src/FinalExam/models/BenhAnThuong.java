package FinalExam.models;

public class BenhAnThuong extends BenhAn {
    private double phiNamVien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(int soThuTu, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" +
                "soThuTu=" + soThuTu +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", maBenhNhan='" + maBenhNhan + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                ", phiNamVien=" + phiNamVien +
                '}';
    }
}
