package com.ibagroup.carrental.service.mapper.car;

import com.ibagroup.carrental.dao.model.car.Car;
import com.ibagroup.carrental.service.dto.car.CarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toDto(Car car);

    List<CarDto> toListDto(List<Car> cars);

    Car toEntity(CarDto carDto);

}
