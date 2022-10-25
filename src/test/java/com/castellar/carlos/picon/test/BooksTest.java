package com.castellar.carlos.picon.test;

import com.castellar.carlos.picon.Books;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooksTest {

    @Test
    void setTitleTest(){
        Books testTitle = new Books();
        testTitle.setTitle("It");
        assertEquals("It", testTitle.getTitle(),
                "The Expected result and the introduced data is not the same");
    }
}
