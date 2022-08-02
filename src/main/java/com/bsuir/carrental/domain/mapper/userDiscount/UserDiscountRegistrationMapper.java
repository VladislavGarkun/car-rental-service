package com.bsuir.carrental.domain.mapper.userDiscount;

import com.bsuir.carrental.dao.model.userDiscount.UserDiscount;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountRegistrationDto;

public interface UserDiscountRegistrationMapper {

    UserDiscount toEntity(UserDiscountRegistrationDto userDiscountRegistrationDto);

}