package com.challengesix.challenge.six.service;

import com.challengesix.challenge.six.Repository.OrderRepository;
import com.challengesix.challenge.six.exception.ResourceNotFoundException;
import com.challengesix.challenge.six.model.Customer;
import com.challengesix.challenge.six.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private static OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(String orderId) throws ResourceNotFoundException {
        Order order = orderRepository.getOrder(Integer.parseInt(orderId));
        if (order == null || order.getOrder_id() != Integer.parseInt(orderId)) {
            String message = "Order not found";
            throw new ResourceNotFoundException(message);
        } else {
            return order;
        }
    }

    public Order insertOrder(int id) {
        Date date = new Date(System.currentTimeMillis());
        OrderRepository.orderMap.put(id, new Order(id, date));
        return new Order(id, date);
    }

    public static Order updateOrder(int id) {
        Order order = orderRepository.getOrder(id);
        order.setOrder_date(new Date(System.currentTimeMillis()));
        return order;
    }


    public void deleteOrder(String orderId) {
        OrderRepository.orderMap.remove(orderId);
    }
}
