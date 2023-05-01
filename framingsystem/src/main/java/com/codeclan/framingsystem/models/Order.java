package com.codeclan.framingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @JsonIgnoreProperties({"orders"})
    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private Order order;

    @JsonIgnoreProperties({"orders"})
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @Column(name="products")
    private List<Product> products;

    public Order(String date, String requiredDate, Enum deliveryType, boolean deleted) {
        this.date = date;
        this.requiredDate = requiredDate;
        this.deliveryType = deliveryType;
        this.deleted = deleted;
        this.products = new ArrayList<Product>();
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
