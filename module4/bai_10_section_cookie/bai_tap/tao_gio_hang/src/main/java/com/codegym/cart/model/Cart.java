package com.codegym.cart.model;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_bill")
    private Integer idCart;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private Integer quantity;

    public Cart() {
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCard) {
        this.idCart = idCard;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void deleteProduct(){
        quantity--;
    }

    public void addProduct(){
        quantity++;
    }

    public double getPrice(){
        return product.getNewPrice() * quantity;
    }
}
