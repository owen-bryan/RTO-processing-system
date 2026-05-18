package com.owen.RTO_processing_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.owen.RTO_processing_system.service.MockPaymentService;
import com.owen.RTO_processing_system.service.PaymentService;

@Configuration
public class PaymentServiceConfig {
    
    @Bean
    PaymentService service () {
        return new MockPaymentService();
    }
}
