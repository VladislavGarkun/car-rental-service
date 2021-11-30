package com.ibagroup.carrental.model.review;

import com.ibagroup.carrental.model.car.Car;
import com.ibagroup.carrental.model.user.User;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer mark;
    private String comment;

}
