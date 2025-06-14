package com.dev.crud.repositories;

import com.dev.crud.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository extends JpaRepository<Order, Long> { }

