package com.bsuir.carrental.domain.mapper.userDiscount;

import com.bsuir.carrental.dao.model.userDiscount.UserDiscount;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDiscountMapper {

    UserDiscountDto toDto(UserDiscount userDiscount);

    UserDiscount toEntity(UserDiscountDto userDiscountDto);

}