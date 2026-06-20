package com.owen.RTO_processing_system.dto.out;

import java.util.List;
import java.util.UUID;

import com.owen.RTO_processing_system.model.OrderItems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

public class ProductReservedEvent {
    @Getter
    @Setter
    private UUID orderID;
    @Getter
    @Setter
    private List<OrderItems> product;
}
