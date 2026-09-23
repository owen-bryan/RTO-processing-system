package com.owen.RTO_processing_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owen.RTO_processing_system.model.Product;
import com.owen.RTO_processing_system.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping ("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll()
    {
        log.info("Getting all products");
        List<Product> allProduct = productRepository.findAll();

        return allProduct;
    }
}
