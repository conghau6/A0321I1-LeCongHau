package case_study_furama_resort._models;

public class House extends Facility{
    private int roomStandard; //1 đến 5 sao
    private int numberFloors;

    public House() {
        super();
    }

    public House(String tenDv, double dienTichSd, double chiPhiThue, int soLuongNgToiDa, char kieuThue, int roomStandard, int numberFloors) {
        super(tenDv, dienTichSd, chiPhiThue, soLuongNgToiDa, kieuThue);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "tenDv='" + super.getTenDv() + '\'' +
                ", dienTichSd=" + super.getDienTichSd() +
                ", chiPhiThue=" + super.getChiPhiThue() +
                ", soLuongNgToiDa=" + super.getSoLuongNgToiDa() +
                ", kieuThue=" + super.getKieuThue() +
                ", roomStandard=" + roomStandard +
                ", numberFloors=" + numberFloors +
                '}';
    }

    public static void main(String[] args) {
        House house = new House("house",1000,200.4,30,'Y',5,6);
        System.out.println(house);
    }
}
