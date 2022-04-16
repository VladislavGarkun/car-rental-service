package com.ibagroup.carrental.service.review;

import com.ibagroup.carrental.service.dto.review.ReviewDto;
import com.ibagroup.carrental.service.dto.review.ReviewRegistrationDto;

import java.util.List;

public interface ReviewService {

    ReviewDto addReview(ReviewRegistrationDto reviewRegistrationDto);

    ReviewDto findReviewById(Long reviewId);

    List<ReviewDto> findAllReviews();

    ReviewDto updateReview(ReviewDto reviewDto);

    void deleteReviewById(Long reviewId);

}
