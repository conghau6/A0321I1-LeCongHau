package CaseStudy.models;

public class Customer extends Person {
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String date, String gender, String idCard, String phone, String email, String typeCustomer, String address) {
        super(id, name, date, gender, idCard, phone, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
