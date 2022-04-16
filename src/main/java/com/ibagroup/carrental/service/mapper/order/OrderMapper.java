package com.ibagroup.carrental.service.mapper.order;

import com.ibagroup.carrental.dao.model.order.Order;
import com.ibagroup.carrental.service.dto.order.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Order order);

    List<OrderDto> toListDto(List<Order> orders);
}
