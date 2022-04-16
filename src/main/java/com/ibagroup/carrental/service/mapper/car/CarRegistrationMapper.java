package com.ibagroup.carrental.service.mapper.car;

import com.ibagroup.carrental.dao.model.car.Car;
import com.ibagroup.carrental.service.dto.car.CarRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarRegistrationMapper {

    Car toEntity(CarRegistrationDto carRegistrationDto);

}
