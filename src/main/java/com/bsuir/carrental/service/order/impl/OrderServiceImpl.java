package com.bsuir.carrental.service.order.impl;

import com.bsuir.carrental.domain.dto.order.OrderRegistrationDto;
import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.dao.model.order.Order;
import com.bsuir.carrental.dao.repository.order.OrderRepository;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.order.OrderDto;
import com.bsuir.carrental.domain.mapper.order.OrderMapper;
import com.bsuir.carrental.domain.mapper.order.OrderRegistrationMapper;
import com.bsuir.carrental.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderRegistrationMapper orderRegistrationMapper;

    @Override
    public List<OrderDto> findOrdersByUserName(String userName) {
        List<Order> orders = orderRepository.findOrdersByUserName(userName);

        List<OrderDto> orderDtoList = orderMapper.toListDto(orders);

        return orderDtoList;
    }

    @Override
    public List<OrderDto> findAllOrders() {
        List<Order> orders = orderRepository.findAll();

        List<OrderDto> orderDtoList = orderMapper.toListDto(orders);

        return orderDtoList;
    }

    @Override
    public OrderDto findOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).get();

        OrderDto orderDto = orderMapper.toDto(order);

        return orderDto;
    }

    @Override
    public ResponseEntity addOrder(OrderRegistrationDto orderRegistrationDto) {
        if (orderRegistrationDto.getStartDate().isAfter(orderRegistrationDto.getEndDate())){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.DATE_MISMATCH.getMessage()));
        }

        Order order = orderRegistrationMapper.toEntity(orderRegistrationDto);

        orderRepository.save(order);

        OrderDto orderDto = orderMapper.toDto(order);

        return ResponseEntity.ok(orderDto);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);

        orderRepository.save(order);

        OrderDto response = orderMapper.toDto(order);

        return response;
    }

}