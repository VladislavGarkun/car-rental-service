package com.bsuir.carrental.domain.mapper.car;

import com.bsuir.carrental.dao.model.car.Car;
import com.bsuir.carrental.domain.dto.car.CarRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarRegistrationMapper {

    Car toEntity(CarRegistrationDto carRegistrationDto);

}