package com.bsuir.carrental.domain.mapper.order;

import com.bsuir.carrental.dao.model.order.Order;
import com.bsuir.carrental.domain.dto.order.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Order order);

    List<OrderDto> toListDto(List<Order> orders);
}