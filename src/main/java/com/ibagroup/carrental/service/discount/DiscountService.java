package com.ibagroup.carrental.service.discount;

import com.ibagroup.carrental.service.dto.discount.DiscountDto;
import com.ibagroup.carrental.service.dto.discount.DiscountRegistrationDto;

import java.util.List;

public interface DiscountService {

    DiscountDto addDiscount(DiscountRegistrationDto discountRegistrationDto);

    List<DiscountDto> findAllDiscounts();

    DiscountDto findDiscountById(Long userId);

    DiscountDto findDiscountByName(String name);

    DiscountDto updateDiscount(DiscountDto discountDto);

    void deleteDiscountById(Long discountId);

}
