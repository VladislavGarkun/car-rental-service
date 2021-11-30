package com.ibagroup.carrental.service.review;

import com.ibagroup.carrental.dto.review.ReviewDto;
import com.ibagroup.carrental.model.review.Review;
import com.ibagroup.carrental.repo.car.CarRepo;
import com.ibagroup.carrental.repo.review.ReviewRepo;
import com.ibagroup.carrental.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo repo;

    private final CarRepo carRepo;
    private final UserRepo userRepo;

    @Autowired
    ReviewService(ReviewRepo repo, CarRepo carRepo, UserRepo userRepo){
        this.repo = repo;
        this.carRepo = carRepo;
        this.userRepo = userRepo;
    }

    public Review addReview(ReviewDto review) {
        Review entity = new Review();
        entity.setCar(carRepo.findById(review.getCarId()).get());
        entity.setUser(userRepo.findById(review.getUserId()).get());
        entity.setMark(review.getMark());
        entity.setComment(review.getComment());

        repo.save(entity);

        return entity;
    }

    public Review getReviewById(Long reviewId) {
        return repo.findById(reviewId).get();
    }

    public List<Review> getAllReviews() {
        return repo.findAll();
    }

    public Review updateReview(Review review) {
        return repo.save(review);
    }

    public void deleteReviewById(Long reviewId) {
        repo.deleteById(reviewId);
    }
}
