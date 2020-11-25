package com.mx.controller;

import com.mx.model.Customer;
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
        try {
            User _user = userRepository
                    .save(new User(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.isEnabled()));
            log.info("START... Sending email");
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
