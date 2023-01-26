package com.castellar.carlos.picon;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name ="books")
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int books_id;

    private String title;
    private int year;
    private float price;
    private String description;
    private String condition_book;
    private String plot;
    private String cover;
    private int language_id;

    @ManyToOne
    @JoinColumn(name ="language_id", insertable = false, updatable = false)
    //@JsonIgnore
    private Language language;
    public Books(String title, int year ,float price, String description, String condition_book,
                 String plot, String cover,  int language_id){

        this.title = title;
        this.year = year;
        this.price = price;
        this.description = description;
        this.condition_book = condition_book;
        this.plot =plot;
        this.cover = cover;
        this.language_id = language_id;


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
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
   public void setCondition(String condition_book) {
       this.condition_book = condition_book;
   }

   public String getCondition() {
       return condition_book;
   }

   public void setPlot(String plot) {
       this.plot = plot;
   }

   public String getPlot() {
       return plot;
   }

   public void setCover(String cover) {
       this.cover = cover;
   }
   public String getCover() {
       return cover;
   }

   public int getLanguage_id() {
       return language_id;
   }

   public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
   public Language getLanguage() {
       return language;
   }

   public void setLanguage(Language language) {
       this.language = language;

   }
    public Books(){

    }
}

