package com.rickie.controller;

import com.rickie.domain.model.OrderEntity;
import com.rickie.repository.OrderRepository;
import com.rickie.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public long createOrder(@RequestBody OrderEntity orderEntity){
        System.out.println("***** CustomerId: " + orderEntity.getCustomerId());
        orderEntity.confirmReceived();
        orderRepository.save(orderEntity);
        return orderEntity.getId();
    }
}
