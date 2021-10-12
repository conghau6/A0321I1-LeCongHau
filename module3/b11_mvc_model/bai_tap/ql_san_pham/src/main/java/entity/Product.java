package entity;

public class Product {
    Integer id;
    String name;
    String type;
    String desc;
    Double price;
    String urlImage;

    public Product() {
    }

    public Product(Integer id, String name, String type, String desc, Double price, String urlImage) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.price = price;
        this.urlImage = urlImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
