package com.ibagroup.carrental.service.mapper.order.impl;

import com.ibagroup.carrental.dao.model.order.Order;
import com.ibagroup.carrental.dao.repository.car.CarRepository;
import com.ibagroup.carrental.dao.repository.user.UserRepository;
import com.ibagroup.carrental.service.dto.order.OrderRegistrationDto;
import com.ibagroup.carrental.service.mapper.order.OrderRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class OrderRegistrationMapperImpl implements OrderRegistrationMapper {

    private static final String ACTIVE = "ACTIVE";

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public Order toEntity(OrderRegistrationDto orderRegistrationDto){
        Order order = new Order();
        order.setUser(userRepository.findUserByUserName(orderRegistrationDto.getUserName()));
        order.setCar(carRepository.findById(orderRegistrationDto.getCarId()).get());
        order.setStartDate(orderRegistrationDto.getStartDate());
        order.setEndDate(orderRegistrationDto.getEndDate());

        Float price = carRepository.findById(orderRegistrationDto.getCarId()).get().getPrice();
        Float orderPrice = calculationPrice(orderRegistrationDto, price);

        order.setPrice(orderPrice);
        order.setStatus(ACTIVE);

        return order;
    }

    private Float calculationPrice(OrderRegistrationDto orderRegistrationDto, Float price) {
        Long period = ChronoUnit.DAYS.between(orderRegistrationDto.getStartDate(), orderRegistrationDto.getEndDate()) + 1;

        return period * price;
    }

}