package com.castellar.carlos.picon.test;

import com.castellar.carlos.picon.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {

    @Test
    void setFirst_nameTest(){
        Author testFirst_name = new Author();
        testFirst_name.setFirst_name("Alan");
        assertEquals("Alan", testFirst_name.getFirst_name(),
                "The Expected result and the introduced data is not the same");
    }
}
