package com.castellar.carlos.picon.test;

import com.castellar.carlos.picon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension .class)//Inehereting characteristic needed to use mockito
public class MockitoBooksTest {
    private CastellarDBApplication castellarDBApplication;
    @Mock
    private BooksRepository booksRepository;

    @Mock
    private BooksHAuthorRepository booksHauthorRepository;
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private ImagesRepository imagesRepository;
    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private OrdersRepository ordersRepository;
    @Mock
    private UsersRepository usersRepository;
    @Mock
    private UsersHOrdersRepository usersHordersRepository;


    @BeforeEach
//creating an instance of our DB with no data
    void Setup() {
        castellarDBApplication = new CastellarDBApplication(

                booksRepository,
                booksHauthorRepository,
                authorRepository,
                imagesRepository,
                languageRepository,
                ordersRepository,
                usersRepository,
                usersHordersRepository



        );
    }
    /********************Author**********************/
    @Test
    public void getGetMappingAuthorTest() {
        Author testAuthor1 = new Author( "Alan", "Stewart" , "", "US");
        Author testAuthor2 = new Author("Robert","Van Dijk" , "", "Nederland");
        List<Author> authorList = new ArrayList<>();
        authorList.add(testAuthor1);
        authorList.add(testAuthor2);
        when(castellarDBApplication.getAllAuthor()).thenReturn(authorList);
        Assertions.assertEquals(authorList, castellarDBApplication.getAllAuthor(),

                "The Expected list and the introduced data is not the same");
    }


    /********************Books**********************/
    /*@Test
    public void testAddBook() {
        Books saveBook = new Books( "It", 1995,4, "Best book ever", "Good",
                "plot1","paperback", 1);//Post request for Mock DB
        String expected = "save";//response
        String actual = castellarDBApplication.addBook(saveBook.getTitle(),
                saveBook.getYear(), saveBook.getPrice(), saveBook.getDescription(),
                saveBook.getCondition(), saveBook.getPlot(),saveBook.getCover(), saveBook.getLanguage_id());
        ArgumentCaptor<Books> booksArgumentCaptor = ArgumentCaptor.forClass(Books.class);
        //Verifying that repo has saved instance
        verify(booksRepository).save(booksArgumentCaptor.capture());
        booksArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data hasnt been added to mock");
    }*/
    @Test
    public void getGetMappingBooksTest() {
        Books testBook1 = new Books( "It", 1995, 4, "Best book ever", "Good",
                "plot1", "paperback", 298, 1, 1, "in stock");
        Books testBook2 = new Books( "La Reina del Sur", 2007, 3, "A great book",
                "Used","A drug dealer woman arrive to the south of Spain", "Hardcover",
                 320, 3, 1, "in stock");
        List<Books> bookList = new ArrayList<>();
        bookList.add(testBook1);
        bookList.add(testBook2);
        when(castellarDBApplication.getAllBooks()).thenReturn(bookList);
        Assertions.assertEquals(bookList, castellarDBApplication.getAllBooks(),

                "The Expected list and the introduced data is not the same");
    }
}