package com.bsuir.carrental.domain.mapper.review.impl;

import com.bsuir.carrental.dao.model.review.Review;
import com.bsuir.carrental.dao.repository.user.UserRepository;
import com.bsuir.carrental.domain.dto.review.ReviewRegistrationDto;
import com.bsuir.carrental.domain.mapper.review.ReviewRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewRegistrationMapperImpl implements ReviewRegistrationMapper {

    private final UserRepository userRepository;

    @Override
    public Review toEntity(ReviewRegistrationDto reviewRegistrationDto){
        Review review = new Review();
        review.setUser(userRepository.findUserByUserName(reviewRegistrationDto.getUserName()));
        review.setMark(reviewRegistrationDto.getMark());
        review.setComment(reviewRegistrationDto.getComment());

        return review;
    }

}