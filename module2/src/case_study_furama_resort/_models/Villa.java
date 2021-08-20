package case_study_furama_resort._models;

public class Villa extends  Facility{
    private int roomStandard; //1 đến 5 sao
    private double swimmingPoolArea;
    private int numberFloors;

    public Villa() {
        super();
    }

    public Villa(String tenDv, double dienTichSd, double chiPhiThue, int soLuongNgToiDa, char kieuThue, int roomStandard, double swimmingPoolArea, int numberFloors) {
        super(tenDv, dienTichSd, chiPhiThue, soLuongNgToiDa, kieuThue);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberFloors = numberFloors;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "tenDv='" + super.getTenDv() + '\'' +
                ", dienTichSd=" + super.getDienTichSd() +
                ", chiPhiThue=" + super.getChiPhiThue() +
                ", soLuongNgToiDa=" + super.getSoLuongNgToiDa() +
                ", kieuThue=" + super.getKieuThue() +
                ", roomStandard=" + roomStandard +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberFloors=" + numberFloors +
                '}';
    }

    public static void main(String[] args) {
        Villa villa = new Villa("villa",1000,200.4,30,'Y',5,30.5,6);
        System.out.println(villa);
    }
}
