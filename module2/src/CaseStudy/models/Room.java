package CaseStudy.models;

public class Room extends Facility {
    private String serviceFree;

    public Room() {
    }

    public Room(String nameService, String areaUsed, double rentalFee, int maxPerson, String rentalType, String serviceFree) {
        super(nameService, areaUsed, rentalFee, maxPerson, rentalType);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serviceFree='" + serviceFree + '\'' +
                ", nameService='" + nameService + '\'' +
                ", areaUsed='" + areaUsed + '\'' +
                ", rentalFee=" + rentalFee +
                ", maxPerson=" + maxPerson +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
