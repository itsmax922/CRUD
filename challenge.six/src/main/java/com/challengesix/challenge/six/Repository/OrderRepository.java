package com.challengesix.challenge.six.Repository;

import com.challengesix.challenge.six.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;

@Repository
public class OrderRepository {

    public static HashMap<Integer, Order> orderMap = new HashMap<>();

    static {
        orderMap.put(1, new Order(1, new Date(System.currentTimeMillis())));
        orderMap.put(2, new Order(2, new Date(System.currentTimeMillis())));
        orderMap.put(3, new Order(3, new Date(System.currentTimeMillis())));
    }

    public Order getOrder(int orderId) {
        return orderMap.getOrDefault(orderId, null);
    }
}