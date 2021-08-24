package case_study_furama_resort._models;

public class Room extends Facility {
    private String tenDv;
    private String dichVuFree;
    public Room() {
        super();
    }

    public Room(String tenDv, double dienTichSd, double chiPhiThue, int soLuongNgToiDa, char kieuThue, String dichVuFree) {
        super(tenDv, dienTichSd, chiPhiThue, soLuongNgToiDa, kieuThue);
        this.dichVuFree = dichVuFree;
    }
    public String getDichVuFree() {
        return dichVuFree;
    }

    public void setDichVuFree(String dichVuFree) {
        this.dichVuFree = dichVuFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "tenDv='" + tenDv + '\'' +
                ", dienTichSd=" + dienTichSd +
                ", chiPhiThue=" + chiPhiThue +
                ", soLuongNgToiDa=" + soLuongNgToiDa+
                ", kieuThue=" + kieuThue +
                ", dichVuFree=" + dichVuFree +
                '}';
    }

    public static void main(String[] args) {
        Room room = new Room("hau" ,1000,200.4,30,'Y',"Villa");
        System.out.println(room);
    }
}
