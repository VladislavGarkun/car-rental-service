package com.bsuir.carrental.service.discount;

import com.bsuir.carrental.domain.dto.discount.DiscountDto;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountRegistrationDto;
import com.bsuir.carrental.domain.dto.discount.DiscountRegistrationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DiscountService {

    ResponseEntity addDiscount(DiscountRegistrationDto discountRegistrationDto);

    List<DiscountDto> findAllDiscounts();

    ResponseEntity giveDiscount(UserDiscountRegistrationDto userDiscountRegistrationDto);
}