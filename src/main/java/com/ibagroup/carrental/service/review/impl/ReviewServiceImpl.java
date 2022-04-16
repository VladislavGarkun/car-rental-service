package com.ibagroup.carrental.service.review.impl;

import com.ibagroup.carrental.dao.model.review.Review;
import com.ibagroup.carrental.dao.repository.review.ReviewRepository;
import com.ibagroup.carrental.service.dto.review.ReviewDto;
import com.ibagroup.carrental.service.dto.review.ReviewRegistrationDto;
import com.ibagroup.carrental.service.mapper.car.CarMapper;
import com.ibagroup.carrental.service.mapper.review.ReviewMapper;
import com.ibagroup.carrental.service.mapper.review.ReviewRegistrationMapper;
import com.ibagroup.carrental.service.mapper.user.UserMapper;
import com.ibagroup.carrental.service.mapper.userRole.UserRoleMapper;
import com.ibagroup.carrental.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ReviewRegistrationMapper reviewRegistrationMapper;
    private final UserMapper userMapper;
    private final CarMapper carMapper;
    private final UserRoleMapper userRoleMapper;

    @Override
    public ReviewDto addReview(ReviewRegistrationDto reviewRegistrationDto) {
        Review review = reviewRegistrationMapper.toEntity(reviewRegistrationDto);

        Review savedReview = reviewRepository.save(review);

        return reviewMapper.toDto(savedReview);
    }

    @Override
    public ReviewDto findReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).get();

        return fromEntityToDto(review);
    }

    @Override
    public List<ReviewDto> findAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();

        List<ReviewDto> reviewDtoList = reviewMapper.toListDto(reviewList);
        for(int i = 0; i < reviewList.size(); i++){
            reviewDtoList.get(i).setUser(userMapper.toDto(reviewList.get(i).getUser()));
            reviewDtoList.get(i).getUser().setUserRoleDto(userRoleMapper.toDto(reviewList.get(i).getUser().getUserRole()));
            reviewDtoList.get(i).setCar(carMapper.toDto(reviewList.get(i).getCar()));
        }

        return reviewDtoList;
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto) {
        Review review = reviewMapper.toEntity(reviewDto);

        Review updatedReview = reviewRepository.save(review);

        return fromEntityToDto(review);
    }

    @Override
    public void deleteReviewById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    private ReviewDto fromEntityToDto(Review review){
        ReviewDto reviewDto = reviewMapper.toDto(review);
        reviewDto.setUser(userMapper.toDto(review.getUser()));
        reviewDto.getUser().setUserRoleDto(userRoleMapper.toDto(review.getUser().getUserRole()));
        reviewDto.setCar(carMapper.toDto(review.getCar()));

        return reviewDto;
    }

}