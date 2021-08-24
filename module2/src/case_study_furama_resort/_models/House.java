package case_study_furama_resort._models;

public class House extends Facility {
    private String tenDv;
    private int tieuChuanPhong; //1 đến 5 sao
    private int soTang;

    public House() {
        super();
    }

    public House(String tenDv, double dienTichSd, double chiPhiThue, int soLuongNgToiDa, char kieuThue, int tieuChuanPhong, int soTang) {
        super(tenDv, dienTichSd, chiPhiThue, soLuongNgToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public int getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(int tieuChuanPhong) {
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
                "tenDv='" + tenDv + '\'' +
                ", dienTichSd=" + dienTichSd +
                ", chiPhiThue=" + chiPhiThue +
                ", soLuongNgToiDa=" + soLuongNgToiDa +
                ", kieuThue=" + kieuThue +
                ", tieuChuanPhong=" + tieuChuanPhong +
                ", soTang=" + soTang +
                '}';
    }

    public static void main(String[] args) {
        House house = new House("hhwef",1000, 200.4, 30, 'Y', 5, 6);
        System.out.println(house);
    }
}
