package com.castellar.carlos.picon;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@SpringBootApplication

@RestController
@RequestMapping("/Homepage")

@CrossOrigin(origins = {"http://localhost:3000", "http://castellar09dec23.s3-website.eu-west-2.amazonaws.com"})
public class CastellarDBApplication {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private BooksHAuthorRepository booksHauthorRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ImagesRepository imagesRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersHOrdersRepository usersHordersRepository;

    private String save ="save";
    public CastellarDBApplication(BooksRepository booksRepository,
                                  BooksHAuthorRepository booksHauthorRepository,
                                  AuthorRepository  authorRepository,
                                  ImagesRepository imagesRepository,
                                  LanguageRepository  languageRepository,
                                  OrdersRepository ordersRepository,
                                  UsersRepository usersRepository,
                                  UsersHOrdersRepository usersHordersRepository){


        this.booksRepository = booksRepository;
        this.booksHauthorRepository = booksHauthorRepository;
        this.authorRepository = authorRepository;
        this.imagesRepository = imagesRepository;
        this.languageRepository = languageRepository;
        this.ordersRepository = ordersRepository;
        this.usersRepository = usersRepository;
        this.usersHordersRepository = usersHordersRepository;

    }

    public static void main(String[] args) {


        SpringApplication.run(CastellarDBApplication.class, args);
    }

    /********************Author**********************/
    @PostMapping("/AddAuthors")
    public @ResponseBody
    String addAuthor(@RequestParam  String first_name, String middle_name, String last_name, String country){
        Author addAuthor = new Author (first_name, middle_name, last_name, country);
        authorRepository.save(addAuthor);
        return save;
    }
    @GetMapping("/AllAuthor")
    public @ResponseBody
    Iterable<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @DeleteMapping("/DeleteAuthors/{author_id}")
    public @ResponseBody
    String removeAuthors(@PathVariable int author_id){
        authorRepository.deleteById(author_id);
        return "The author was removed";
    }
    @CrossOrigin(origins = {"http://localhost:3000", "http://castellar09dec23.s3-website.eu-west-2.amazonaws.com"})
    //@CrossOrigin(origins = "http://castellar09dec23.s3-website.eu-west-2.amazonaws.com")
    @PutMapping("/updateAuthors/{author_id}")
    public @ResponseBody
    String updateAuthor(@PathVariable int author_id, @RequestParam  String first_name, 
                        String middle_name, String last_name, String country){
        Author updateAuthor = authorRepository.findById(author_id)
                .orElseThrow(() ->new ResourceNotFoundException("Author ID not found"));
        updateAuthor.setFirst_name(first_name);
        updateAuthor.setMiddle_name(middle_name);
        updateAuthor.setLast_name(last_name);
        updateAuthor.setCountry(country);
        final Author updatedAuthor = authorRepository.save(updateAuthor);
        return "Updated";
    }
    /********************Books**********************/
    @PostMapping("/AddBooks")
    public @ResponseBody
    String addBook(@RequestParam  String title , int year, float price , String description,
            String condition_book, String plot, String cover, int num_pag, int language_id, int author_id, String image1,
            String image2, String image3, String image4, String image5, String availability){
        Images addImage = new Images(image1, image2, image3, image4, image5);
        imagesRepository.save(addImage);
        Books addBook = new Books(title, year, price, description, condition_book, plot, cover, num_pag, language_id,
                                  addImage.getImages_id(), availability);
        booksRepository.save(addBook);
        Books_has_Author addBook_Author = new Books_has_Author(addBook.getBooks_id(), author_id);
        booksHauthorRepository.save(addBook_Author);
        return save;
    }
    @PutMapping("/updateBooks/{books_id}")
    public @ResponseBody
    String updateBooks(@PathVariable int books_id, @RequestParam String title , int year, float price , String description,
                       String condition_book, String plot, String cover, int num_pag, int language_id,
                       int author_id, String availability){
        Books updateBooks = booksRepository.findById(books_id)
                .orElseThrow(() ->new ResourceNotFoundException("Books ID not found"));
        Books_has_Author updateBook_Has_Author = booksHauthorRepository.findById(books_id)
                .orElseThrow(() ->new ResourceNotFoundException("Books ID not found"));
        updateBooks.setTitle(title);
        updateBooks.setYear(year);
        updateBooks.setPrice(price);
        updateBooks.setDescription(description);
        updateBooks.setCondition(condition_book);
        updateBooks.setPlot(plot);
        updateBooks.setCover(cover);
        updateBooks.setNum_pag(num_pag);
        updateBooks.setLanguage_id(language_id);
        updateBooks.setAvailability(availability);
        updateBook_Has_Author.setAuthor_id(author_id);
        final Books_has_Author updatedBook_Has_Author = booksHauthorRepository.save(updateBook_Has_Author);
        final Books updatedBooks = booksRepository.save(updateBooks);

        return "Updated";
    }
    @GetMapping("/AllBooks")
    public @ResponseBody
    Iterable<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    @GetMapping("/SomeBooks")
    List<Books> getBookssByTitlePiece(@RequestParam String title_piece) {
        return booksRepository.findByTitleContainingIgnoreCase(title_piece);
    }

    @DeleteMapping("/DeleteBooks/{book_id}")
    public @ResponseBody
    String removeBook(@PathVariable int book_id){
        booksRepository.deleteById(book_id);
        return "The book was removed";
    }

    /********************Books_Has_Author**********************/
    @GetMapping("/AllBook_Author")
    public @ResponseBody
    Iterable<Books_has_Author> getAllBooks_has_author(){
        return booksHauthorRepository.findAll();
    }
    @PostMapping("/AddBooks_Has_Author")
    public @ResponseBody
    String addBook_Author(@RequestParam int books_id, int author_id){

        Books_has_Author addBook_Author = new Books_has_Author(books_id, author_id);
        booksHauthorRepository.save(addBook_Author);
        return save;
    }
    /********************Images****************************/
    @PostMapping("/AddImages")
    public @ResponseBody
    String addImage(@RequestParam  String image1, String image2, String image3, String image4,
                                   String image5){
        Images addImage = new Images(image1, image2, image3, image4, image5);
        imagesRepository.save(addImage);
        return save;
    }
    @GetMapping("/AllImages")
    public @ResponseBody
    Iterable<Images> getAllImages(){
        return imagesRepository.findAll();
    }
    /********************Languages****************************/

    @GetMapping("/AllLanguages")
    public @ResponseBody
    Iterable<Language> getAllLanguages(){
        return languageRepository.findAll();
    }

    @PostMapping("/AddLanguages")
    public @ResponseBody
    String addLanguage(@RequestParam String name){
        Language addLanguage = new Language(name);
        languageRepository.save(addLanguage);
        return save;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //@CrossOrigin(origins = "http://castellar09dec23.s3-website.eu-west-2.amazonaws.com")
    @PutMapping("/updateLanguage/{language_id}")
    public @ResponseBody
    String updateLanguage(@PathVariable int language_id, @RequestParam String name){
        Language updateLanguage = languageRepository.findById(language_id)
                .orElseThrow(() ->new ResourceNotFoundException("Language ID not found"));
        updateLanguage.setName(name);
        final Language updatedLanguage = languageRepository.save(updateLanguage);
        return "Updated";
    }
    @DeleteMapping("/DeleteLanguages/{language_id}")
    public @ResponseBody
    String removeLanguage(@PathVariable int language_id){
        languageRepository.deleteById(language_id);
        return "The language was removed";
    }
    /********************Orders**********************/
    @GetMapping("/AllOrders")
    public @ResponseBody
    Iterable<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    @PostMapping("/AddOrders")
    public @ResponseBody
    String addOrders(@RequestParam String reference_number, String status, String purchase_date,
                                   int users_id, float price_total, float price_items, int quantity, float shipping_cost) {
        Orders addOrders = new Orders(reference_number, status, purchase_date, users_id, price_total,price_items ,quantity, shipping_cost);
        ordersRepository.save(addOrders);
        Users_has_Orders addUsers_Orders = new Users_has_Orders(addOrders.getOrders_id(), users_id);
        usersHordersRepository.save(addUsers_Orders);
        return save;
    }

    @PutMapping("/updateOrder/{orders_id}")
    public @ResponseBody
    String updateOrder(@PathVariable int orders_id, @RequestParam String status){
        Orders updateOrder = ordersRepository.findById(orders_id)
                .orElseThrow(() ->new ResourceNotFoundException("ID not fund"));
        updateOrder.setStatus(status);
        final Orders updatedOrder = ordersRepository.save(updateOrder);
        return "Updated";
    }
    /********************Users**********************/
    @PostMapping("/AddUsers")
        public @ResponseBody
        String addUser(@RequestParam String first_name, String last_name, String email,
                String gender, String dob, String username, String password, String city,
                String address, String post_code, String phone_number, boolean admin,
                String admin_password, String state){
            Users addUser = new Users(first_name,last_name,gender, dob, email,username, password,
                    city, address, post_code, phone_number,admin,admin_password, state);
            usersRepository.save(addUser);

            return save;
    }
    @GetMapping("/AllUsers")
    public @ResponseBody
    Iterable<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/SomeUsers/username") //method to get users by username
    public ResponseEntity<List<Users>> getUserByName(@RequestParam String username){
        return new ResponseEntity<List<Users>>(usersRepository.findByUsername(username), HttpStatus.OK);
    }

    @DeleteMapping("/DeleteUsers/{users_id}")
    public @ResponseBody
    String removeUser(@PathVariable int users_id){
        usersRepository.deleteById(users_id);
        return "The user was removed";
    }
    @PutMapping("/updateUser/{users_id}")
    public @ResponseBody
    String updateUser(@PathVariable int users_id, @RequestParam String first_name, String last_name,
                      String email, String gender, String dob, String username, String password,
                      String city, String address, String post_code, String phone_number,
                      boolean admin, String admin_password, String state){
        Users updateUser = usersRepository.findById(users_id)
                .orElseThrow(() ->new ResourceNotFoundException("User ID not found"));
        updateUser.setFirst_name(first_name);
        updateUser.setLast_name(last_name);
        updateUser.setEmail(email);
        updateUser.setGender(gender);
        updateUser.setDob(dob);
        updateUser.setUsername(username);
        updateUser.setPassword(password);
        updateUser.setCity(city);
        updateUser.setAddress(address);
        updateUser.setPost_code(post_code);
        updateUser.setPhone_number(phone_number);
        updateUser.setAdmin(admin);
        updateUser.setAdmin_password(admin_password);
        updateUser.setState(state);
        final Users updatedUser = usersRepository.save(updateUser);
        return "Updated";
    }

    @PutMapping("/activateUser/{username}")
    public String getProductByName(@PathVariable String username) {
        Users updateUser = usersRepository.findOnlyByUsername(username);

        if(updateUser.getState().equals("active")){
            return "Already active";
        }else{
            updateUser.setState("active");
            final Users updatedUser = usersRepository.save(updateUser);
            if (updateUser != null) {
                return "Activated";
            } else {
                return "Something went wrong";
            }
        }

    }
    @GetMapping("/UsersByID/{users_id}")
    public @ResponseBody
    Optional<Users> getUsersByID(@PathVariable int users_id){

        return usersRepository.findById(users_id);
    }
    /********************Users_Has_Orders**********************/
    @PostMapping("/AddUsers_Has_Order")
    public @ResponseBody
    String addUser_Order(@RequestParam int orders_id, int users_id){

        Users_has_Orders addUser_Order = new Users_has_Orders(orders_id, users_id);
        usersHordersRepository.save(addUser_Order);
        return save;
    }
}
