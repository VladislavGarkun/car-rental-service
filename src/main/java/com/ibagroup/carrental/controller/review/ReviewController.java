package com.ibagroup.carrental.controller.review;

import com.ibagroup.carrental.dto.review.ReviewDto;
import com.ibagroup.carrental.model.review.Review;
import com.ibagroup.carrental.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.List;

@RestController
@RequestMapping("/v2/review")
public class ReviewController {

    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addReview(@RequestBody ReviewDto review){
        Review entity = service.addReview(review);

        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "/{reviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReviewById(@PathVariable("reviewId") Long reviewId){
        Review review = service.getReviewById(reviewId);

        return ResponseEntity.ok(review);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Review> getAllReview(){
        List<Review> reviews = service.getAllReviews();

        return reviews;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateReview(@RequestBody Review review){
        Review entity = service.updateReview(review);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "{reviewId}")
    public void deleteReviewById(@PathVariable("reviewId") Long reviewId){
        service.deleteReviewById(reviewId);
    }

}
