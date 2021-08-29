package CaseStudy.models;

public class House extends Facility {
    private String standardRoom;
    private int numFloor;

    public House() {
    }

    public House(String nameService, String areaUsed, double rentalFee, int maxPerson, String rentalType, String standardRoom, int numFloor) {
        super(nameService, areaUsed, rentalFee, maxPerson, rentalType);
        this.standardRoom = standardRoom;
        this.numFloor = numFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", numFloor=" + numFloor +
                ", nameService='" + nameService + '\'' +
                ", areaUsed='" + areaUsed + '\'' +
                ", rentalFee=" + rentalFee +
                ", maxPerson=" + maxPerson +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
