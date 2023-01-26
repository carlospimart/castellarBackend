package com.castellar.carlos.picon;

import javax.persistence.*;

@Entity
@Table(name ="books_has_author")
public class Books_has_Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int books_id;
    private int author_id;

    public Books_has_Author(int books_id, int author_id){

        this.books_id = books_id;
        this.author_id = author_id;

    }

    public int getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int books_id) {
        this.books_id = books_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    public Books_has_Author(){

    }
}
