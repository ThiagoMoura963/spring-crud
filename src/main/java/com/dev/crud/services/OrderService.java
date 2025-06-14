package com.dev.crud.services;

import com.dev.crud.entities.Order;
import com.dev.crud.repositories.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRespository respository;

    public List<Order> findAll() {
        return respository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = respository.findById(id);
        return obj.get();
    }
}
