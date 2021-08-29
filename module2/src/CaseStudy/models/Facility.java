package CaseStudy.models;

public abstract class Facility {
    protected String nameService;
    protected String areaUsed;
    protected double rentalFee;
    protected int maxPerson;
    protected String rentalType;

    public Facility() {
    }

    public Facility(String nameService, String areaUsed, double rentalFee, int maxPerson, String rentalType) {
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentalFee = rentalFee;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(String areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }
}
