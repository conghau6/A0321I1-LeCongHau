package case_study_furama_resort._models;

public class Contracts {
    private int soHopDong;
    private int maBooking;
    private double tienCocTruoc;
    private double tongTienTT;
    private int maKh;

    public Contracts() {
    }

    public Contracts(int soHopDong, int maBooking, double tienCocTruoc, double tongTienTT, int maKh) {
        this.soHopDong = soHopDong;
        this.maBooking = maBooking;
        this.tienCocTruoc = tienCocTruoc;
        this.tongTienTT = tongTienTT;
        this.maKh = maKh;
    }

    public int getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(int soHopDong) {
        this.soHopDong = soHopDong;
    }

    public int getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(int maBooking) {
        this.maBooking = maBooking;
    }

    public double getTienCocTruoc() {
        return tienCocTruoc;
    }

    public void setTienCocTruoc(double tienCocTruoc) {
        this.tienCocTruoc = tienCocTruoc;
    }

    public double getTongTienTT() {
        return tongTienTT;
    }

    public void setTongTienTT(double tongTienTT) {
        this.tongTienTT = tongTienTT;
    }

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    @Override
    public String toString() {
        return "Contracts{" +
                "soHopDong=" + soHopDong +
                ", maBooking=" + maBooking +
                ", tienCocTruoc=" + tienCocTruoc +
                ", tongTienTT=" + tongTienTT +
                ", maKh=" + maKh +
                '}';
    }
}
