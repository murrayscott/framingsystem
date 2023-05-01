package com.codeclan.framingsystem.components;

import com.codeclan.framingsystem.models.*;
import com.codeclan.framingsystem.repositories.CustomerRepository;
import com.codeclan.framingsystem.repositories.OrderRepository;
import com.codeclan.framingsystem.repositories.PartRepository;
import com.codeclan.framingsystem.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PartRepository partRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Order order1 = new Order("04-05-23","23-05-23", DeliveryType.COLLECTION,false);
        orderRepository.save(order1);
        Customer customer1 = new Customer("Still Game","Jack Jarvis","","","","","","","",true,true);
        customerRepository.save(customer1);

        Product product1 = new Product("",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,false);
        productRepository.save(product1);
        Part part1 = new Part("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false);
        partRepository.save(part1);
    }
}