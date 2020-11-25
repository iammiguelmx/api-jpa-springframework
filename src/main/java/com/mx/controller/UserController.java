package com.mx.controller;

import com.mx.model.Customer;
import com.mx.model.Mail;
import com.mx.model.User;
import com.mx.repository.UserRepository;
import com.mx.ults.EmailSenderService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@Api(tags = "User", description = "Enpoint for Usuarios")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    private EmailSenderService emailService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        Mail mail = new Mail();
        try {
            User _user = userRepository.save(new
                            User(user.getId(), user.getUsername(),
                                    user.getPassword(),user.getRole(),
                                    user.isEnabled(), user.getEmail(), user.getAddress(), user.getCompany()));
            log.info("START... Sending email");
            mail.setFrom("miguel.cam.mx@gmail.com");
            mail.setMailTo(user.getEmail());
            mail.setSubject("Welcome .....");
            Map<String, Object> modelMail = new HashMap<>();
            modelMail.put("name", _user.getUsername());
            mail.setProps(modelMail);
            emailService.sendEmail(mail, "homeNotSignedIn");
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<User>> getAll(@RequestParam(required = false) String title) {
        try {
            List<User> users = new ArrayList<User>();
            if (title == null)
                userRepository.findAll().forEach(users::add);
            else
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
