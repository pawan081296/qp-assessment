package com.qp.assesment.controller;

import com.qp.assesment.model.request.OrderProductRequest;
import com.qp.assesment.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public void saveOrder(@Valid @RequestBody OrderProductRequest order) {
        orderService.saveOrder(order);
    }
}
