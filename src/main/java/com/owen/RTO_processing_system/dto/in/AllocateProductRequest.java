package com.owen.RTO_processing_system.dto.in;

import java.util.List;
import java.util.UUID;

import com.owen.RTO_processing_system.model.OrderItems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class AllocateProductRequest {
    
    @Getter
    @Setter
    private UUID orderId;

    @Getter
    @Setter
    private List<OrderItems> OrderItems;
}
