package com.castellar.carlos.picon;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;

    private String first_name;
    private String middle_name;
    private String last_name;
    private String country;


    public Author(String first_name, String middle_name, String last_name, String country){

        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.country = country;
    }
    @ManyToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Books> books = new HashSet<>();




    public int getAuthor_id() {
        return author_id;
    }

    //needed to Many-to-Many mapping
    public Set<Books> getBooks() {
        return books;
    }
    public void setBooks(Set<Books> books) {
        this.books = books;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name= last_name;
    }

    public String getLast_name() { return last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    public Author(){

    }
}
