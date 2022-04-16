package com.ibagroup.carrental.dao.model.drivingLicense;

import com.ibagroup.carrental.dao.model.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "driving_license")
@Data
public class DrivingLicense {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    /**
     * Ссылка на фотографию
     */
    @Column(name = "photo_url")
    @Size(message = "photo_url{DrivingLicense.size}", max = 1000)
    private String photoUrl;

}