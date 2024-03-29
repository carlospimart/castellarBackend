package com.castellar.carlos.picon;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
    @Entity
    @Table(name ="users")
    public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int users_id;

        //Setting up many to many with language category
       /* @OneToMany
        @JoinColumn(name ="language_id",insertable = false,updatable = false)
        @JsonIgnore
        private Set<Film> film;*/


        private String first_name;
        private String last_name;
        private String gender;
        private String dob;
        private String email;
        private String username;
        private String password;
        private String city;
        private String address;
        private String post_code;
        private String phone_number;
        private boolean admin;
        private String admin_password;
        private String state;

        public Users(String first_name, String last_name, String gender,
                     String dob,String email, String username, String password,
                     String city, String address, String post_code, String phone_number,
                     boolean admin, String admin_password, String state){
            this.first_name = first_name;
            this.last_name = last_name;
            this.gender = gender;
            this.dob = dob;
            this.email = email;
            this.username = username;
            this.password = password;
            this.city = city;
            this.address = address;
            this.post_code = post_code;
            this.phone_number = phone_number;
            this.admin = admin;
            this.admin_password = admin_password;
            this.state = state;

        }
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
        @JoinTable(name = "users_has_orders",
                joinColumns = {
                        @JoinColumn(name = "users_id", referencedColumnName = "users_id",
                                nullable = false, updatable = false)},
                inverseJoinColumns = {
                        @JoinColumn(name = "orders_id", referencedColumnName = "orders_id",
                                nullable = false, updatable = false)})
        private Set<Orders> orders = new HashSet<>();

        public Set<Orders> getOrders() {

            return orders;
        }

        public void setAuthor(Set<Orders> orders) {
            this.orders = orders;
        }
        public int getUsers_id() {
            return users_id;
        }
        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setGender(String Gender) {
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getDob() {
            return dob;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setPost_code(String post_code) {
            this.post_code = post_code;
        }

        public String getPost_code() {
            return post_code;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public boolean getAdmin() {
            return admin;
        }

        public void setAdmin_password(String admin_password) {
            this.admin_password = admin_password;
        }

        public String getAdmin_password() {
            return admin_password;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public Users(){

        }
    }

