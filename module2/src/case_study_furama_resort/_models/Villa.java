package case_study_furama_resort._models;

public class Villa extends  Facility{
    private int tieuChuanPhong; //1 đến 5 sao
    private double dtHoBoi;
    private int soTang;

    public Villa() {
        super();
    }

    public Villa(String tenDv, double dienTichSd, double chiPhiThue, int soLuongNgToiDa, char kieuThue, int tieuChuanPhong, double dtHoBoi, int soTang) {
        super(tenDv, dienTichSd, chiPhiThue, soLuongNgToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.dtHoBoi = dtHoBoi;
        this.soTang = soTang;
    }

    public int getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(int tieuChuanPhong) {
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
                "tenDv='" + tenDv + '\'' +
                ", dienTichSd=" + dienTichSd +
                ", chiPhiThue=" + chiPhiThue +
                ", soLuongNgToiDa=" + soLuongNgToiDa +
                ", kieuThue=" + kieuThue +
                ", tieuChuanPhong=" + tieuChuanPhong +
                ", dienTichHoBoi=" + dtHoBoi +
                ", soTang=" + soTang +
                '}';
    }

    public static void main(String[] args) {
        Villa villa = new Villa("villa",1000,200.4,30,'Y',5,30.5,6);
        System.out.println(villa);
    }
}
