package case_study_furama_resort._models;

public abstract class Facility {
    protected double dienTichSd;
    protected double chiPhiThue;
    protected int soLuongNgToiDa;
    protected char kieuThue; //'Y': theo năm, 'M' theo tháng, 'D': theo ngàym, 'H' theo giờ

    public Facility() {
    }

    public Facility(double dienTichSd, double chiPhiThue, int soLuongNgToiDa, char kieuThue) {
        this.dienTichSd = dienTichSd;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNgToiDa = soLuongNgToiDa;
        this.kieuThue = kieuThue;
    }

    public double getDienTichSd() {
        return dienTichSd;
    }

    public void setDienTichSd(double dienTichSd) {
        this.dienTichSd = dienTichSd;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoLuongNgToiDa() {
        return soLuongNgToiDa;
    }

    public void setSoLuongNgToiDa(int soLuongNgToiDa) {
        this.soLuongNgToiDa = soLuongNgToiDa;
    }

    public char getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(char kieuThue) {
        this.kieuThue = kieuThue;
    }

    @Override
    public String toString() {
        return "Facility{" +
                ", dienTichSd=" + dienTichSd +
                ", chiPhiThue=" + chiPhiThue +
                ", soLuongNgToiDa=" + soLuongNgToiDa +
                ", kieuThue=" + kieuThue +
                '}';
    }
}
