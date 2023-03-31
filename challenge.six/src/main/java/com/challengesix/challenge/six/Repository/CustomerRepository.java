package com.challengesix.challenge.six.Repository;

import com.challengesix.challenge.six.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CustomerRepository {

    public static HashMap<Integer, Customer> customerMap = new HashMap<>();

    static {
        customerMap.put(1, new Customer(1, "Mukul"));
        customerMap.put(2, new Customer(2, "Abhishek"));
        customerMap.put(3, new Customer(3, "Sudha"));
    }

    public Customer getCustomer(int customerId) {
        return customerMap.getOrDefault(customerId, null);
    }
}
