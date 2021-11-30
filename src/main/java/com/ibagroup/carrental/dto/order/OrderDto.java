package com.ibagroup.carrental.dto.order;

import com.ibagroup.carrental.model.order.OrderStatusEnum;
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
    private OrderStatusEnum status;
    private boolean complete;

}
