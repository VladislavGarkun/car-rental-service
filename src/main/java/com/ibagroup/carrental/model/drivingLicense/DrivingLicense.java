package com.ibagroup.carrental.model.drivingLicense;

import com.ibagroup.carrental.model.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "driving_license")
@Data
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String photoUrl;

}
