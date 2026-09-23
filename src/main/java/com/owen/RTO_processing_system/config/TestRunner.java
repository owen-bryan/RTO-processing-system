package com.owen.RTO_processing_system.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.model.OrderStatus;
import com.owen.RTO_processing_system.model.Product;
import com.owen.RTO_processing_system.repository.OrderRepository;
import com.owen.RTO_processing_system.repository.ProductRepository;

@Configuration
public class TestRunner {
    
    
    @Bean
    CommandLineRunner runProducts (ProductRepository repo) {
        return args -> {
            Product oranges = new Product("Orange", 73);
            Product bacon = new Product("Bacon", 40);
            Product milk = new Product("Milk", 25);

            repo.save(oranges);
            repo.save(bacon);
            repo.save(milk);
        };
    }

    @Bean
    @DependsOn ("runProducts")
    CommandLineRunner run (OrderRepository repo, ProductRepository productRepository) {
        return args -> {
            Order order = new Order (UUID.randomUUID(), new BigDecimal(99.99), OrderStatus.CREATED, new ArrayList<>());
            Product product = productRepository.findByName("Orange").get(0);
            order.addItem(product, 4, new BigDecimal(1.25));
            repo.save (order);

            System.out.println("Saved Order:" + order.getId());
            System.out.println("All Orders:" + repo.findAll());
        };
    }
}
