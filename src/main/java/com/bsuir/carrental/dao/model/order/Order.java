package com.bsuir.carrental.dao.model.order;

import com.bsuir.carrental.dao.model.car.Car;
import com.bsuir.carrental.dao.model.user.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
public class Order {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Пользователь оформивший заказ
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Машина взятая в аренду
     */
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    /**
     * Дата начала действия заказа
     */
    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    /**
     * Дата окончания действия заказа
     */
    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    /**
     * Стоимость заказа
     */
    @Column(name = "price")
    private Float price;

    /**
     * Статус заказа
     */
    @Column(name = "status")
    @Size(message = "status{Order.size}", max = 100)
    private String status;

}