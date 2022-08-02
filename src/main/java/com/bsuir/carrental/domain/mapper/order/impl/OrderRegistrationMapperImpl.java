package com.bsuir.carrental.domain.mapper.order.impl;

import com.bsuir.carrental.dao.model.discount.Discount;
import com.bsuir.carrental.dao.model.userDiscount.UserDiscount;
import com.bsuir.carrental.dao.repository.dicount.DiscountRepository;
import com.bsuir.carrental.dao.repository.user.UserRepository;
import com.bsuir.carrental.dao.repository.userDiscount.UserDiscountRepository;
import com.bsuir.carrental.domain.dto.order.OrderRegistrationDto;
import com.bsuir.carrental.dao.model.order.Order;
import com.bsuir.carrental.dao.model.user.User;
import com.bsuir.carrental.dao.repository.car.CarRepository;
import com.bsuir.carrental.domain.mapper.order.OrderRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderRegistrationMapperImpl implements OrderRegistrationMapper {

    private static final String PENDING = "Pending";

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final DiscountRepository discountRepository;
    private final UserDiscountRepository userDiscountRepository;

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
        order.setStatus(PENDING);

        return order;
    }

    private Float calculationPrice(OrderRegistrationDto orderRegistrationDto, Float price) {
        Long period = ChronoUnit.DAYS.between(orderRegistrationDto.getStartDate(), orderRegistrationDto.getEndDate()) + 1;

        User user = userRepository.findUserByUserName(orderRegistrationDto.getUserName());
        List<UserDiscount> userDiscountList = userDiscountRepository.findUserDiscountsByUserId(user.getId());
        if (userDiscountList.isEmpty()){
            return period * price;
        } else {
            List<Long> idList = new ArrayList<>();
            for (int i = 0; i < userDiscountList.size(); i++) {
                idList.add(userDiscountList.get(i).getDiscount().getId());
            }
            List<Discount> discountList = discountRepository.findDiscountsByIdIn(idList);
            List<Float> valueList = new ArrayList<>();
            for (int i = 0; i < discountList.size(); i++) {
                valueList.add(discountList.get(i).getValue());
            }
            return period * price * ((100 - Collections.max(valueList)) / 100);
        }
    }

}