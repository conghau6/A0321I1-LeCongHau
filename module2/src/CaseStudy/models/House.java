package CaseStudy.models;

public class House extends Facility {
    private String tieuChuanPhong;
    private int soTang;

    public House() {
    }

    public House(int id, String tenDv, double dtSd, double phiThue, int soNgToiDa, String kieuThue, String tieuChuanPhong, int soTang) {
        super(id, tenDv, dtSd, phiThue, soNgToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "House{" +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", soTang=" + soTang +
                ", id=" + id +
                ", tenDv='" + tenDv + '\'' +
                ", dtSd=" + dtSd +
                ", phiThue=" + phiThue +
                ", soNgToiDa=" + soNgToiDa +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }
}
