package com.bsuir.carrental.service.review.impl;

import com.bsuir.carrental.dao.model.review.Review;
import com.bsuir.carrental.dao.repository.review.ReviewRepository;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.review.ReviewDto;
import com.bsuir.carrental.domain.mapper.userRole.UserRoleMapper;
import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.domain.dto.review.ReviewRegistrationDto;
import com.bsuir.carrental.domain.mapper.review.ReviewMapper;
import com.bsuir.carrental.domain.mapper.review.ReviewRegistrationMapper;
import com.bsuir.carrental.domain.mapper.user.UserMapper;
import com.bsuir.carrental.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ReviewRegistrationMapper reviewRegistrationMapper;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    @Override
    public ResponseEntity addReview(ReviewRegistrationDto reviewRegistrationDto) {
        if (reviewRegistrationDto.getMark() == null || reviewRegistrationDto.getComment().isEmpty()){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }

        Review review = reviewRegistrationMapper.toEntity(reviewRegistrationDto);

        Review savedReview = reviewRepository.save(review);

        ReviewDto reviewDto = reviewMapper.toDto(savedReview);

        return ResponseEntity.ok(reviewDto);
    }

    @Override
    public List<ReviewDto> findAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();

        List<ReviewDto> reviewDtoList = reviewMapper.toListDto(reviewList);
        for(int i = 0; i < reviewList.size(); i++){
            reviewDtoList.get(i).setUser(userMapper.toDto(reviewList.get(i).getUser()));
            reviewDtoList.get(i).getUser().setUserRole(userRoleMapper.toDto(reviewList.get(i).getUser().getUserRole()));
        }

        return reviewDtoList;
    }

}