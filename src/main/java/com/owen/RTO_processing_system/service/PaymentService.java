
package com.owen.RTO_processing_system.service;

import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.in.PaymentRequest;
import com.owen.RTO_processing_system.dto.out.PaymentResult;

@Service
public interface PaymentService {

    PaymentResult charge (PaymentRequest request);
    
}