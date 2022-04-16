package com.ibagroup.carrental.service.mapper.discount;

import com.ibagroup.carrental.dao.model.discount.Discount;
import com.ibagroup.carrental.service.dto.discount.DiscountRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountRegistrationMapper {

    Discount toEntity(DiscountRegistrationDto discountRegistrationDto);

}
