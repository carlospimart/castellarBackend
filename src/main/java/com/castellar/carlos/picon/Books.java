package com.castellar.carlos.picon;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name ="books")
@Entity
public class Books {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int books_id;

    private int year;
    private int language_id;
    private String title;
    private float price;
    private String condition;
    private String plot;

    @ManyToOne
    @JoinColumn(name ="language_id", insertable = false, updatable = false)
    private Language language;
    public Books(String title, int year, int language_id, float price, String condition,
                 String plot){

        this.title = title;
        this.year = year;
        this.language_id = language_id;
        this.price = price;
        this.condition = condition;
        this.plot =plot;

    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "books_has_author",
            joinColumns = {
                    @JoinColumn(name = "books_id", referencedColumnName = "books_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "author_id",
                            nullable = false, updatable = false)})
    private Set<Author> author = new HashSet<>();

    public Set<Author> getAuthor() {

        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }



    public int getBooks_id() {
        return books_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }



    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPlot() {
        return plot;
    }
    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
    public int getLanguage_id() {
        return language_id;
    }
    public Books(){

    }
}

