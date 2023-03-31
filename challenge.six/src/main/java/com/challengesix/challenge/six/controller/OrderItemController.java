package com.challengesix.challenge.six.controller;

import com.challengesix.challenge.six.model.OrderItems;
import com.challengesix.challenge.six.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemsService;

    @PostMapping("/orderItems")
    public ResponseEntity<OrderItems> insertOrderItem(@RequestParam(value = "id") int id, @RequestParam(value = "quantity") int quantity) {
        OrderItems orderItems = orderItemsService.insertQuantity(id, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItems);
    }

    @PutMapping("/orderItems/{orderId}")
    public ResponseEntity<OrderItems> updateOrderItem(@RequestParam(value = "id") int orderId, @RequestParam(value = "quantity") int quantity) {
        OrderItems updateOrderItem = orderItemsService.updateQuantity(orderId, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateOrderItem);
    }

    @DeleteMapping("/orderItems/{orderId}")
    public void deleteOrderItem(@RequestParam(value = "id") int orderId) {
        orderItemsService.deleteQuantity(orderId);
    }
}