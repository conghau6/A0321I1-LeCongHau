package CaseStudy.models;

public abstract class Facility {
    protected int id;
    protected String tenDv;
    protected double dtSd;
    protected double phiThue;
    protected int soNgToiDa;
    protected String kieuThue;

    public Facility() {
    }

    public Facility(int id, String tenDv, double dtSd, double phiThue, int soNgToiDa, String kieuThue) {
        this.id = id;
        this.tenDv = tenDv;
        this.dtSd = dtSd;
        this.phiThue = phiThue;
        this.soNgToiDa = soNgToiDa;
        this.kieuThue = kieuThue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public double getDtSd() {
        return dtSd;
    }

    public void setDtSd(double dtSd) {
        this.dtSd = dtSd;
    }

    public double getPhiThue() {
        return phiThue;
    }

    public void setPhiThue(double phiThue) {
        this.phiThue = phiThue;
    }

    public int getSoNgToiDa() {
        return soNgToiDa;
    }

    public void setSoNgToiDa(int soNgToiDa) {
        this.soNgToiDa = soNgToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }
}
