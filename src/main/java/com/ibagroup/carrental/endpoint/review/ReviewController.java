package com.ibagroup.carrental.endpoint.review;

import com.ibagroup.carrental.service.dto.review.ReviewDto;
import com.ibagroup.carrental.service.dto.review.ReviewRegistrationDto;
import com.ibagroup.carrental.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addReview(@RequestBody ReviewRegistrationDto reviewRegistrationDto){
        ReviewDto reviewDto = service.addReview(reviewRegistrationDto);

        return ResponseEntity.ok(reviewDto);
    }

    @GetMapping(value = "/{reviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReviewById(@PathVariable("reviewId") Long reviewId){
        ReviewDto reviewDto = service.findReviewById(reviewId);

        return ResponseEntity.ok(reviewDto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewDto> getAllReview(){
        List<ReviewDto> reviews = service.findAllReviews();

        return reviews;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateReview(@RequestBody ReviewDto reviewDto){
        ReviewDto response = service.updateReview(reviewDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "{reviewId}")
    public void deleteReviewById(@PathVariable("reviewId") Long reviewId){
        service.deleteReviewById(reviewId);
    }

}
