package com.bsuir.carrental.domain.mapper.car;

import com.bsuir.carrental.dao.model.car.Car;
import com.bsuir.carrental.domain.dto.car.CarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toDto(Car car);

    List<CarDto> toListDto(List<Car> cars);

    Car toEntity(CarDto carDto);

}