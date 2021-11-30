package com.ibagroup.carrental.dto.review;

import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private Long carId;
    private Long userId;
    private Integer mark;
    private String comment;

}
