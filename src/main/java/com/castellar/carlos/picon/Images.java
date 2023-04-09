package com.castellar.carlos.picon;

import javax.persistence.*;


@Entity
@Table(name ="images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int images_id;

    private String image1;


    public Images(String image1){

        this.image1 = image1;

    }
    public int getImages_id() {
        return images_id;
    }


    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
    public Images(){

    }
}
