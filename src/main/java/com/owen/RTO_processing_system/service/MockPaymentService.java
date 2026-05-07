package com.owen.RTO_processing_system.service;

import com.owen.RTO_processing_system.dto.PaymentRequest;
import com.owen.RTO_processing_system.dto.PaymentResult;

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
