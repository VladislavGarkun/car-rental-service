package com.bsuir.carrental.dao.model.blackList;

import com.bsuir.carrental.dao.model.user.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "black_list")
public class BlackList {

    /**
     * Уникальнй идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Пользователь, добавляемый в черный список
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Причина занесения в черный список
     */
    @Column(name = "reason")
    @Size(message = "reason{BlackList.size}", max = 1000)
    private String reason;

    /**
     * Дата занесения в черный список
     */
    @Column(name = "date_of_add")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfAdd;

}