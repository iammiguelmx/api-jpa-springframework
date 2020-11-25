package com.mx.controller;


import com.mx.model.Customer;
import com.mx.repository.CustumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/custumers")
public class CustumerController {

    @Autowired
    CustumerRepository custumerRepository;

    @GetMapping("/showAll")
    public ResponseEntity<List<Customer>> getAll(@RequestParam(required = false) String title) {
        try {
            List<Customer> tutorials = new ArrayList<Customer>();
            if (title == null)
                custumerRepository.findAll().forEach(tutorials::add);
            else
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustumer(@Valid @RequestBody Customer customer) {
        try {
            Customer _custumer = custumerRepository
                    .save(new Customer(customer.getId(), customer.getFirstName(), customer.getLastName()));
            return new ResponseEntity<>(_custumer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer> getCustumerById(@PathVariable("id") long id) {
        Optional<Customer> data = custumerRepository.findById(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustumer(@PathVariable("id") long id) {
        try {
            custumerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
