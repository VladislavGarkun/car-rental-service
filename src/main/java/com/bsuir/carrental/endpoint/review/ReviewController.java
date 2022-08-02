package com.bsuir.carrental.endpoint.review;

import com.bsuir.carrental.domain.dto.review.ReviewDto;
import com.bsuir.carrental.domain.dto.review.ReviewRegistrationDto;
import com.bsuir.carrental.service.review.ReviewService;
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
        ResponseEntity entity = service.addReview(reviewRegistrationDto);

        return entity;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewDto> getAllReview(){
        List<ReviewDto> reviews = service.findAllReviews();

        return reviews;
    }

}