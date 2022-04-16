package com.ibagroup.carrental.service.mapper.discount;

import com.ibagroup.carrental.dao.model.discount.Discount;
import com.ibagroup.carrental.service.dto.discount.DiscountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountMapper {

    Discount toEntity(DiscountDto discountDto);

    DiscountDto toDto(Discount discount);

    List<DiscountDto> toListDto(List<Discount> discounts);

}