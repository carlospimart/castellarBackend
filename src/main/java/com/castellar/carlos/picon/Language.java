package com.castellar.carlos.picon;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name ="language")
public class Language{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int language_id;

        //Setting up many to many with language category
       /* @OneToMany
        @JoinColumn(name ="language_id",insertable = false,updatable = false)
        @JsonIgnore
        private Set<Film> film;*/

        private String name;

        public Language(String name){

            this.name = name;

        }

        public int getLanguage_id() {
            return language_id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        /*public Set<Film>getFilm(){
            return film;
        }

        public void setFilm(Set<Film> film) {
            this.film = film;
        }*/
        public Language(){

        }
    }


