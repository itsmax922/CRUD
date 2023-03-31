package com.challengesix.challenge.six.service;

import com.challengesix.challenge.six.Repository.CustomerRepository;
import com.challengesix.challenge.six.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private static CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }
    public static Customer insertCustomer(int customerId, String customerName) {
        CustomerRepository.customerMap.put(customerId, new Customer(customerId, customerName));
        return new Customer(customerId, customerName);
    }

    public static Customer updateCustomer(int customerId, String customerName) {
        Customer customer = customerRepository.getCustomer(customerId);
        customer.setCustomer_name(customerName);
        return customer;
    }

    public static void deleteCustomer(int customerId) {
        CustomerRepository.customerMap.remove(customerId);
    }
}
