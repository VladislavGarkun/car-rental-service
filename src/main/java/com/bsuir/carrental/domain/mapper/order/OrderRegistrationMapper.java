package com.bsuir.carrental.domain.mapper.order;

import com.bsuir.carrental.domain.dto.order.OrderRegistrationDto;
import com.bsuir.carrental.dao.model.order.Order;

public interface OrderRegistrationMapper {

    Order toEntity(OrderRegistrationDto orderRegistrationDto);

}