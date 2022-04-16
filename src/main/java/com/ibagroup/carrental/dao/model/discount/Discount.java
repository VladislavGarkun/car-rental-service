package com.ibagroup.carrental.dao.model.discount;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "discounts")
@Data
public class Discount {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Название скидки
     */
    @Column(name = "name")
    @Size(message = "name{Discount.size}", max = 100)
    private String name;

    /**
     * Значение скидки
     */
    @Column(name = "value")
    private Float value;

}