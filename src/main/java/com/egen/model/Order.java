package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {
    public enum Stats {
        ORDERED,
        TRANSIT,
        DELIVERED
    }
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String orderID;

    @Enumerated(EnumType.STRING)
    private Stats orderStatus;

    private Date dateCreated;
    private Date dateModified;
    private String shippingMethod;

    /**Many orders can belong to one customer*/
    @ManyToOne
    private Customer customer;

    /**One order can have only one Shipping Address*/
    @OneToOne
    private ShippingAddress shipping;

    /** One order can have many items*/
    @OneToMany
    private List<OrderItem> orderItem;

    /**One Order can have only one payment summary*/
    @OneToOne
    private Payment payment;

    public Order(){

    }

    public Order(String id){
        this.orderID = id;
    }
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Stats getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Stats orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingAddress getShipping() {
        return shipping;
    }

    public void setShipping(ShippingAddress shipping) {
        this.shipping = shipping;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderStatus=" + orderStatus +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", customer=" + customer +
                ", shipping=" + shipping +
                ", orderItem=" + orderItem +
                ", payment=" + payment +
                '}';
    }
}
