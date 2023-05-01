package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.Order;
import com.codeclan.framingsystem.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order, Long>{
    List<Order> findOrderById(Long id);
}
