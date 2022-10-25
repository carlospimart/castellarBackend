package com.castellar.carlos.picon;

import javax.persistence.*;

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
        private String email;
        private String username;
        private String password;
        private String city;
        private String address;
        private String post_code;

        public Users(String first_name, String last_name,String email,
                     String username, String password, String city,
                     String address, String post_code){
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.username = username;
            this.password = password;
            this.city = city;
            this.address = address;
            this.post_code = post_code;



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

        public void setUEmail(String email) {
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


        /*public Set<Film>getFilm(){
            return film;
        }

        public void setFilm(Set<Film> film) {
            this.film = film;
        }*/
        public Users(){

        }
    }
