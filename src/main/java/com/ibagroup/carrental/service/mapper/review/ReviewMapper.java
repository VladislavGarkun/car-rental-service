package com.ibagroup.carrental.service.mapper.review;

import com.ibagroup.carrental.dao.model.review.Review;
import com.ibagroup.carrental.service.dto.review.ReviewDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toDto(Review review);

    List<ReviewDto> toListDto(List<Review> reviewList);

    Review toEntity(ReviewDto reviewDto);

}