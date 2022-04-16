package com.ibagroup.carrental.service.order.impl;

import com.ibagroup.carrental.dao.model.order.Order;
import com.ibagroup.carrental.dao.repository.order.OrderRepository;
import com.ibagroup.carrental.service.dto.order.OrderDto;
import com.ibagroup.carrental.service.dto.order.OrderRegistrationDto;
import com.ibagroup.carrental.service.mapper.order.OrderMapper;
import com.ibagroup.carrental.service.mapper.order.OrderRegistrationMapper;
import com.ibagroup.carrental.service.order.OrderService;
import lombok.RequiredArgsConstructor;
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
        List<Order> orders = orderRepository.findByUserName(userName);

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
    public OrderDto addOrder(OrderRegistrationDto orderRegistrationDto) {
        Order order = orderRegistrationMapper.toEntity(orderRegistrationDto);

        orderRepository.save(order);

        OrderDto orderDto = orderMapper.toDto(order);

        return orderDto;
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);

        orderRepository.save(order);

        OrderDto response = orderMapper.toDto(order);

        return response;
    }

    @Override
    public void deleteOrderById(Long orderId){
        orderRepository.deleteById(orderId);
    }

}