package com.bsuir.carrental.dao.model.userDiscount;

import com.bsuir.carrental.dao.model.discount.Discount;
import com.bsuir.carrental.dao.model.user.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users_discounts")
public class UserDiscount {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Пользователь которому принадлежит скидка
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Скидка выданная пользователю
     */
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    /**
     * Дата начала действия скидки
     */
    @Column(name = "date_of_start")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfStart;

    /**
     * Дата окончания действия скидки
     */
    @Column(name = "date_of_end")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfEnd;

}