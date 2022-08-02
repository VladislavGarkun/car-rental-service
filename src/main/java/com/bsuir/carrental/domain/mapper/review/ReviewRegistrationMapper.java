package com.bsuir.carrental.domain.mapper.review;

import com.bsuir.carrental.dao.model.review.Review;
import com.bsuir.carrental.domain.dto.review.ReviewRegistrationDto;

public interface ReviewRegistrationMapper {

    Review toEntity(ReviewRegistrationDto reviewRegistrationDto);

}