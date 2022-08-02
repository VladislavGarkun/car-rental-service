package com.bsuir.carrental.domain.mapper.discount;

import com.bsuir.carrental.dao.model.discount.Discount;
import com.bsuir.carrental.domain.dto.discount.DiscountRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountRegistrationMapper {

    Discount toEntity(DiscountRegistrationDto discountRegistrationDto);

}