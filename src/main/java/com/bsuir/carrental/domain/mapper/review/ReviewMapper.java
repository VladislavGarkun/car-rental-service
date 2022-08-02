package com.bsuir.carrental.domain.mapper.review;

import com.bsuir.carrental.dao.model.review.Review;
import com.bsuir.carrental.domain.dto.review.ReviewDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toDto(Review review);

    List<ReviewDto> toListDto(List<Review> reviewList);

    Review toEntity(ReviewDto reviewDto);

}