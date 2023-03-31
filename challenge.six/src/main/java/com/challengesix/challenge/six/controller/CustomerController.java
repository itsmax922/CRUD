package com.challengesix.challenge.six.controller;

import com.challengesix.challenge.six.model.Customer;
import com.challengesix.challenge.six.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") int customerId) {
        Customer customer = CustomerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PostMapping("/insertCustomer")
    public ResponseEntity<Customer> insertCustomer(@RequestParam(value = "id") int customerId, @RequestParam(value = "name") String customerName) {
        Customer customer = CustomerService.insertCustomer(customerId, customerName);
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestParam(value = "id") int customerId, @RequestParam(value = "name") String customerName) {
        Customer customer = CustomerService.updateCustomer(customerId, customerName);
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity deleteCustomer(@RequestParam int customerId) {
        CustomerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}