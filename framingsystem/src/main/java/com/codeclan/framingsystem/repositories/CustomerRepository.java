package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.Customer;
import com.codeclan.framingsystem.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long>{
    List<Customer> findCustomerByNameIgnoreCase(String name);
    List<Customer> findCustomerByPostcodeIgnoreCase(String name);
}
