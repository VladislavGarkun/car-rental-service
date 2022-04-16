package com.ibagroup.carrental.service.mapper.order;

import com.ibagroup.carrental.dao.model.order.Order;
import com.ibagroup.carrental.service.dto.order.OrderRegistrationDto;

public interface OrderRegistrationMapper {

    Order toEntity(OrderRegistrationDto orderRegistrationDto);

}
