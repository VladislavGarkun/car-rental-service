package com.bsuir.carrental.service.review;

import com.bsuir.carrental.domain.dto.review.ReviewDto;
import com.bsuir.carrental.domain.dto.review.ReviewRegistrationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {

    ResponseEntity addReview(ReviewRegistrationDto reviewRegistrationDto);

    List<ReviewDto> findAllReviews();

}
