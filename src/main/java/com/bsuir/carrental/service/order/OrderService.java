package com.bsuir.carrental.service.order;

import com.bsuir.carrental.domain.dto.order.OrderRegistrationDto;
import com.bsuir.carrental.domain.dto.order.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    List<OrderDto> findOrdersByUserName(String userName);

    List<OrderDto> findAllOrders();

    OrderDto findOrderById(Long orderId);

    ResponseEntity addOrder(OrderRegistrationDto orderRegistrationDto);

    OrderDto updateOrder(OrderDto orderDto);

}
