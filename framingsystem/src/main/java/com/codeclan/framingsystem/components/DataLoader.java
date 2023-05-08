package com.codeclan.framingsystem.components;

import com.codeclan.framingsystem.models.*;
import com.codeclan.framingsystem.repositories.*;
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
    @Autowired
    PresetProductRepository presetProductRepository;
    @Autowired
    PresetPartRepository presetPartRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
//      Create PresetProduct and PresetParts
        PresetProduct presetProduct1 = new PresetProduct("",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,false);
        presetProductRepository.save(presetProduct1);

        PresetPart presetPart1 = new PresetPart("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart2 = new PresetPart("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart3 = new PresetPart("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart4 = new PresetPart("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);

//      Create Sample Customers, orders, products and parts.
        Customer customer1 = new Customer("Jack Jarvis","Still Game","The Clansman","","","","","","",true,true);
        customerRepository.save(customer1);

        Order order1 = new Order("04-05-23","23-05-23", DeliveryType.COLLECTION,false, customer1);
        orderRepository.save(order1);

        Product product1 = new Product("",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,false, order1);
        productRepository.save(product1);

        Part part1 = new Part("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, product1);
        partRepository.save(part1);
    }
}
