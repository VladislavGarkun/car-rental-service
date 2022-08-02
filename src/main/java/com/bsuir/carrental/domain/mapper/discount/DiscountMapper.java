package com.bsuir.carrental.domain.mapper.discount;

import com.bsuir.carrental.dao.model.discount.Discount;
import com.bsuir.carrental.domain.dto.discount.DiscountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountMapper {

    Discount toEntity(DiscountDto discountDto);

    DiscountDto toDto(Discount discount);

    List<DiscountDto> toListDto(List<Discount> discounts);

}