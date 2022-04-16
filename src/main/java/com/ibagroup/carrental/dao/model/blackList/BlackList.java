package com.ibagroup.carrental.dao.model.blackList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.dao.model.user.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Column(name = "reason")
    @Size(message = "reason{BlackList.size}", max = 1000)
    private String reason;

    @Column(name = "date_of_add")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateOfAdd;

}