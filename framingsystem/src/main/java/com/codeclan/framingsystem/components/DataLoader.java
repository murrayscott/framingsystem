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
    @Autowired
    RawPartRepository rawPartRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
//      Create RawParts
        RawPart rawPart1 = new RawPart("Glass",700.0,1000.0,0.0,Type.AREA,1.0,true,0, false);
        rawPartRepository.save(rawPart1);

//      Create PresetProduct and PresetParts
        PresetProduct presetProduct1 = new PresetProduct("Close Framed Print",200.0,300.0,2.0,25.0,25.0,25.0,25.0,1,false);
        presetProductRepository.save(presetProduct1);

        PresetPart presetPart1 = new PresetPart("Glass",350.0,250.0,0.0,Type.AREA,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart2 = new PresetPart("Mount",300.0,200.0,0.0,Type.AREA,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart3 = new PresetPart("Moulding",23.0,45.0,3000.0,Type.LENGTH,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart4 = new PresetPart("Backing",350.0,250.0,0.0,Type.AREA,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart5 = new PresetPart("Cord",0.0,0.0,250.0,Type.AREA,0.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);
        PresetPart presetPart6 = new PresetPart("D-Rings",0.0,0.0,0.0,Type.AREA,2.0,true,0, false, presetProduct1);
        presetPartRepository.save(presetPart1);

//      Create Sample Customers, orders, products and parts.
        Customer customer1 = new Customer("Jack Jarvis","Still Game","The Clansman","Maryhill","","","","01414444444","old.duffer@gmail.com",true,true);
        customerRepository.save(customer1);

        Order order1 = new Order("04-05-23","23-05-23", DeliveryType.COLLECTION,false, customer1);
        orderRepository.save(order1);

        Product product1 = new Product("Close Framed Print",200.0,300.0,2.0,25.0,25.0,25.0,25.0,2,false, order1);
        productRepository.save(product1);

        Part part1 = new Part("Glass",350.0,250.0,0.0,Type.LENGTH,0.0,true,0, false, product1);
        partRepository.save(part1);

        Customer customer2 = new Customer("Victor McDade","Still Game","The Clansman","Maryhill","","","","01412222222","wheresmyzimmer@aol.com",true,true);
        customerRepository.save(customer2);

        Order order2 = new Order("06-05-23","24-05-23", DeliveryType.COLLECTION,false, customer2);
        orderRepository.save(order2);

        Product product2 = new Product("",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,false, order2);
        productRepository.save(product2);

        Part part2 = new Part("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, product2);
        partRepository.save(part2);

        Customer customer3 = new Customer("Winston Ingram","Still Game","The Clansman","Maryhill","","","","01411111111","wheresmyleg@aol.com",true,true);
        customerRepository.save(customer3);

        Order order3 = new Order("02-05-23","22-05-23", DeliveryType.COLLECTION,false, customer3);
        orderRepository.save(order3);

        Product product3 = new Product("",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,false, order3);
        productRepository.save(product3);

        Part part3 = new Part("",0.0,0.0,0.0,Type.LENGTH,0.0,true,0, false, product3);
        partRepository.save(part3);
        partRepository.save(part2);
        partRepository.save(part1);
    }
}
