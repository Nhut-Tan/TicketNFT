package com.example.TicketChain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketChain.dto.request.CreateOrderRequest;
import com.example.TicketChain.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrdersService orderService;

    // API tạo đơn hàng mới kèm transaction
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest) {
        try {
            orderService.createOrder(orderRequest);
            return ResponseEntity.ok("Order created successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
