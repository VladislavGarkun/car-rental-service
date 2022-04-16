package com.ibagroup.carrental.service.mapper.review.impl;

import com.ibagroup.carrental.dao.model.review.Review;
import com.ibagroup.carrental.dao.repository.car.CarRepository;
import com.ibagroup.carrental.dao.repository.user.UserRepository;
import com.ibagroup.carrental.service.dto.review.ReviewRegistrationDto;
import com.ibagroup.carrental.service.mapper.review.ReviewRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewRegistrationMapperImpl implements ReviewRegistrationMapper {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public Review toEntity(ReviewRegistrationDto reviewRegistrationDto){
        Review review = new Review();
        review.setCar(carRepository.findById(reviewRegistrationDto.getCarId()).get());
        review.setUser(userRepository.findUserByUserName(reviewRegistrationDto.getUserName()));
        review.setMark(reviewRegistrationDto.getMark());
        review.setComment(reviewRegistrationDto.getComment());

        return review;
    }

}