package com.ibagroup.carrental.model.order;

import com.ibagroup.carrental.model.car.Car;
import com.ibagroup.carrental.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDate startDate;
    private LocalDate endDate;
    private Float price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
