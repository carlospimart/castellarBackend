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
        /*@OneToMany
        @JoinColumn(name ="language_id",insertable = false,updatable = false)
        //@JsonIgnore
        private Set<Books> books;*/

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

        /*public Set<Books>getBook(){
            return books;
        }

        public void setBook(Set<Books> books) {
            this.books = books;
        }*/
        public Language(){


        }
}


