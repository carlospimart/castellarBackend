package com.castellar.carlos.picon;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;
@SpringBootApplication
@RestController
@RequestMapping("/Homepage")
@CrossOrigin(origins = "http://localhost:3000")
public class CastellarDBApplication {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private UsersRepository usersRepository;

    private String save ="save";
    public CastellarDBApplication(BooksRepository booksRepository,
                                  AuthorRepository  authorRepository,
                                  LanguageRepository  languageRepository,
                                  UsersRepository usersRepository){


        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
        this.usersRepository = usersRepository;


    }

    public static void main(String[] args) {


        SpringApplication.run(CastellarDBApplication.class, args);
    }

    /********************Author**********************/
    @GetMapping("/AllAuthor")
    public @ResponseBody
    Iterable<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    /********************Books**********************/

    @PostMapping("/AddBooks")
    public @ResponseBody
    String addBook(@RequestParam  String title, int year, int language_id, float price,
                   String condition, String plot){
        Books addBook = new Books(title, year, language_id, price, condition, plot);
        booksRepository.save(addBook);
        return save;
    }

    @GetMapping("/AllBooks")
    public @ResponseBody
    Iterable<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    /********************Languages**********************/

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

    /********************Users**********************/
    @PostMapping("/AddUsers")
    public @ResponseBody
    String addUser(@RequestParam String first_name, String last_name, String email,
                   String gender, String dob, String username, String password, String city,
                   String address, String post_code, String phone_number){
        Users addUser = new Users(first_name,last_name,gender, dob, email,username, password,
                                  city, address, post_code, phone_number);
        usersRepository.save(addUser);
        return save;
    }
    @GetMapping("/AllUsers")
    public @ResponseBody
    Iterable<Users> getAllUsers(){
        return usersRepository.findAll();
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
                      String city, String address, String post_code, String phone_number){
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
        final Users updatedUser = usersRepository.save(updateUser);
        return "Updated";
    }
}
