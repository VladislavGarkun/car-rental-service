package com.ibagroup.carrental.model.blackList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "black_list")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String reason;

    private Date dateOfAdd;

}
