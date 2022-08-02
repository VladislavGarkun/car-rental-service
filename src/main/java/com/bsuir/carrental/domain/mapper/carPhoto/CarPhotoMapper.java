package com.bsuir.carrental.domain.mapper.carPhoto;

import com.bsuir.carrental.dao.model.carPhoto.CarPhoto;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarPhotoMapper {

    CarPhoto toEntity(CarPhotoDto carPhotoDto);

    CarPhotoDto toDto(CarPhoto carPhoto);

    List<CarPhotoDto> toListDto(List<CarPhoto> carPhotoList);

}