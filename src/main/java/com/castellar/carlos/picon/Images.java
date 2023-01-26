package com.castellar.carlos.picon;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name ="images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int image_id;
    @Lob
    @Column(name = "image1", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image1;

    public Images(byte[] image1){

        this.image1 = image1;

    }
    public int getImages_id() {
        return image_id;
    }


    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }
    public Images(){

    }
}
