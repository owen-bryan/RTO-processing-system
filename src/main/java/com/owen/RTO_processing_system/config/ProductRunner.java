package com.owen.RTO_processing_system.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.owen.RTO_processing_system.model.Product;
import com.owen.RTO_processing_system.repository.ProductRepository;

@Configuration
public class ProductRunner {
    
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
}
