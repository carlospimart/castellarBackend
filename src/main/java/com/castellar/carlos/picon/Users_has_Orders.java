package com.castellar.carlos.picon;

import javax.persistence.*;

@Entity
@Table(name ="users_has_orders")
public class Users_has_Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int orders_id;
    private int users_id;

    public Users_has_Orders(int orders_id, int users_id) {

        this.orders_id = orders_id;
        this.users_id = users_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public Users_has_Orders(){

    }
}
