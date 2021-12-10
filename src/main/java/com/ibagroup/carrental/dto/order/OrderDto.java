package com.ibagroup.carrental.dto.order;

import com.ibagroup.carrental.model.order.OrderStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {

    private Long id;
    private Long carId;
    private String userName;
    private LocalDate startDate;
    private LocalDate endDate;

}
