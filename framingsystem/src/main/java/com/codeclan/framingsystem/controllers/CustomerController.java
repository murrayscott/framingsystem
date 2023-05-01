package com.codeclan.framingsystem.controllers;

import com.codeclan.framingsystem.models.Customer;
import com.codeclan.framingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping (value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "postcode", required = false) String postcode
    ){
        if (name != null){
            return new ResponseEntity<>(customerRepository.findCustomerByNameIgnoreCase(name), HttpStatus.OK);
        }
        if (postcode != null){
            return new ResponseEntity<>(customerRepository.findCustomerByPostcodeIgnoreCase(postcode), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
