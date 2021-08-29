package CaseStudy.models;

public class Villa extends Facility {
    private String standardRoom;
    private double areaSwimmingPool;
    private int numFloor;

    public Villa() {
    }

    public Villa(String nameService, String areaUsed, double rentalFee, int maxPerson, String rentalType, String standardRoom, double areaSwimmingPool, int numFloor) {
        super(nameService, areaUsed, rentalFee, maxPerson, rentalType);
        this.standardRoom = standardRoom;
        this.areaSwimmingPool = areaSwimmingPool;
        this.numFloor = numFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getAreaSwimmingPool() {
        return areaSwimmingPool;
    }

    public void setAreaSwimmingPool(double areaSwimmingPool) {
        this.areaSwimmingPool = areaSwimmingPool;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", areaSwimmingPool=" + areaSwimmingPool +
                ", numFloor=" + numFloor +
                ", nameService='" + nameService + '\'' +
                ", areaUsed='" + areaUsed + '\'' +
                ", rentalFee=" + rentalFee +
                ", maxPerson=" + maxPerson +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
