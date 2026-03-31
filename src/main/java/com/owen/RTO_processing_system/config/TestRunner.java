package com.owen.RTO_processing_system.config;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.owen.RTO_processing_system.model.Order;
import com.owen.RTO_processing_system.repository.OrderRepository;

@Configuration
public class TestRunner {
    
    @Bean
    CommandLineRunner run (OrderRepository repo) {
        return args -> {
            Order order = new Order (UUID.randomUUID(), new BigDecimal(99.99), "CREATED");

            repo.save (order);

            System.out.println("Saved Order:" + order.getId());
            System.out.println("All Orders:" + repo.findAll());
        };
    }
}
