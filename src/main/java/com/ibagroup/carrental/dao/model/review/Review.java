package com.ibagroup.carrental.dao.model.review;

import com.ibagroup.carrental.dao.model.car.Car;
import com.ibagroup.carrental.dao.model.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Оценка оставленная пользователем
     */
    @Column(name = "mark")
    private Integer mark;

    /**
     * Комментарий пользователя
     */
    @Column(name = "comment")
    @Size(message = "comment{Review.size", max = 5000)
    private String comment;

}
