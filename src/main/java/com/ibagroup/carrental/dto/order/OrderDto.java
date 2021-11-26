package com.ibagroup.carrental.dto.order;

import com.ibagroup.carrental.model.order.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    private Long id;
    private Long carId;
    private Long userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float price;
    private OrderStatus status;
    private boolean complete;

}
