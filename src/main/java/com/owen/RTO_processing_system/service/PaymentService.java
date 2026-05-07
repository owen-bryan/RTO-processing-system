
package com.owen.RTO_processing_system.service;

import com.owen.RTO_processing_system.dto.PaymentRequest;
import com.owen.RTO_processing_system.dto.PaymentResult;

public interface PaymentService {

    PaymentResult charge (PaymentRequest request);
    
}