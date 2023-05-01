package com.codeclan.framingsystem.controllers;

import com.codeclan.framingsystem.models.Order;
import com.codeclan.framingsystem.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> getOrders(
            @RequestParam(name = "id", required = false) Long id
    ){
        if (id != null){
            return new ResponseEntity<>(orderRepository.findOrderById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
}
