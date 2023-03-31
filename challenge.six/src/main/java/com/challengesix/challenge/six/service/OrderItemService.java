package com.challengesix.challenge.six.service;

import com.challengesix.challenge.six.Repository.OrderItemsRepository;
import com.challengesix.challenge.six.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private static OrderItemsRepository orderItemsRepository;


    public OrderItems insertQuantity(int id, int quantity) {
        OrderItems orderItems = new OrderItems(quantity);
        OrderItemsRepository.orderItemMap.put(id,orderItems);
        return orderItems;
    }

    public OrderItems updateQuantity(int id, int quantity) {
        OrderItems orderItems = OrderItemsRepository.orderItemMap.get(id);
        orderItems.setQuantity(quantity);
        return orderItems;
    }

    public void deleteQuantity(int id) {
        OrderItemsRepository.orderItemMap.remove(id);
    }
}
