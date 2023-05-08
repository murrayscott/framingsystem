package com.codeclan.framingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="date")
    private String date;
    @Column(name="required_date")
    private String requiredDate;
    @Column(name="delivery_type")
    private Enum deliveryType;
    @Column(name="deleted")
    private boolean deleted;

//    Link upwards to Customer
    @JsonIgnoreProperties({"orders"})
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    Link downwards to Product
    @JsonIgnoreProperties({"orders"})
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Product> products;


    public Order(String date, String requiredDate, Enum deliveryType, boolean deleted, Customer customer) {
        this.date = date;
        this.requiredDate = requiredDate;
        this.deliveryType = deliveryType;
        this.deleted = deleted;
        this.customer = customer;
        this.products = new ArrayList<Product>();
    }

    public Order() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Enum getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Enum deliveryType) {
        this.deliveryType = deliveryType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
