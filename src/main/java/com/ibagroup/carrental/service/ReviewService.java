package com.ibagroup.carrental.service;

import com.ibagroup.carrental.service.dto.review.ReviewDto;
import com.ibagroup.carrental.dao.model.review.Review;
import com.ibagroup.carrental.dao.repository.car.CarRepository;
import com.ibagroup.carrental.dao.repository.review.ReviewRepository;
import com.ibagroup.carrental.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repo;

    private final CarRepository carRepo;
    private final UserRepository userRepo;

    @Autowired
    ReviewService(ReviewRepository repo, CarRepository carRepo, UserRepository userRepo){
        this.repo = repo;
        this.carRepo = carRepo;
        this.userRepo = userRepo;
    }


}
