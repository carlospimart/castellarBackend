package com.castellar.carlos.picon;

import javax.persistence.*;

@Entity
@Table(name ="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int orders_id;
    private String reference_number;
    private String status;
    private String purchase_date;
    private int users_id;
    private float price_total;
    private int quantity;
    private float shipping_cost;

    public Orders(String reference_number,String status, String date, int users_id,
                  float price_total, int quantity, float shipping_cost){

        this.reference_number = reference_number;
        this.status = status;
        this.purchase_date = date;
        this.users_id = users_id;
        this.price_total = price_total;
        this.quantity = quantity;
        this.shipping_cost = shipping_cost;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }

    public float getPrice_total() {
        return price_total;
    }

    public void setPrice_total(float price_total) {
        this.price_total = price_total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(float shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public String getReference_number() {
        return reference_number;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public Orders(){

    }
}
