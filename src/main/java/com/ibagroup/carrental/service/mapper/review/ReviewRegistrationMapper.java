package com.ibagroup.carrental.service.mapper.review;

import com.ibagroup.carrental.dao.model.review.Review;
import com.ibagroup.carrental.service.dto.review.ReviewRegistrationDto;
import org.mapstruct.Mapper;

public interface ReviewRegistrationMapper {

    Review toEntity(ReviewRegistrationDto reviewRegistrationDto);

}