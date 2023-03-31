package com.challengesix.challenge.six.controller;

import com.challengesix.challenge.six.exception.ResourceNotFoundException;
import com.challengesix.challenge.six.model.Order;
import com.challengesix.challenge.six.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable("orderId") String orderId) {
        try {
            Order fetchedOrder = orderService.getOrderById(orderId);
            return ResponseEntity.ok(fetchedOrder);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> insertOrder(@RequestParam(value = "id") int id) {
        Order insertedOrder = orderService.insertOrder(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedOrder);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestParam("orderId") int orderId) {
        Order updatedOrder = orderService.updateOrder(orderId);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@RequestParam("orderId") String orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }
}