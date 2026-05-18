package com.owen.RTO_processing_system.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.owen.RTO_processing_system.dto.in.PaymentRequest;
import com.owen.RTO_processing_system.dto.out.PaymentResult;

@Service
@Primary
public class MockPaymentService implements PaymentService{

    @Override
    public PaymentResult charge(PaymentRequest request) {
        if (request == null)
            throw new IllegalArgumentException();

        if (Math.random() > 0.2) {
            return PaymentResult.success(request.getAmount(), request.getOrder());
        }

        return PaymentResult.fail(request.getAmount(), request.getOrder());
    }
    
}
