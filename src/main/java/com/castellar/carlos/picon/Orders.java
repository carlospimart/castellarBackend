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

    public Orders(String reference_number,String status, String date){

        this.reference_number = reference_number;
        this.status = status;
        this.purchase_date = date;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
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

    public Orders(){

    }
}
