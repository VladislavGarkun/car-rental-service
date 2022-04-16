package com.ibagroup.carrental.service.order;

import com.ibagroup.carrental.service.dto.order.OrderDto;
import com.ibagroup.carrental.service.dto.order.OrderRegistrationDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findOrdersByUserName(String userName);

    List<OrderDto> findAllOrders();

    OrderDto findOrderById(Long orderId);

    OrderDto addOrder(OrderRegistrationDto orderRegistrationDto);

    OrderDto updateOrder(OrderDto orderDto);

    void deleteOrderById(Long orderId);

}
