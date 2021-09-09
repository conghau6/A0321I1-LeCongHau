package CaseStudy.models;

public class Room extends Facility {
    private String dvFree;

    public Room() {
    }

    public Room(String id, String tenDv, double dtSd, double phiThue, int soNgToiDa, String kieuThue, String dvFree) {
        super(id, tenDv, dtSd, phiThue, soNgToiDa, kieuThue);
        this.dvFree = dvFree;
    }

    public String getDvFree() {
        return dvFree;
    }

    public void setDvFree(String dvFree) {
        this.dvFree = dvFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "dvFree='" + dvFree + '\'' +
                ", id=" + id +
                ", tenDv='" + tenDv + '\'' +
                ", dtSd=" + dtSd +
                ", phiThue=" + phiThue +
                ", soNgToiDa=" + soNgToiDa +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }
}
