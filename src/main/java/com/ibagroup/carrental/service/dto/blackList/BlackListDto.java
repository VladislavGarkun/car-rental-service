package com.ibagroup.carrental.service.dto.blackList;

import lombok.Data;

import java.util.Date;

@Data
public class BlackListDto {

    private Long id;
    private String reason;
    private Date dateOfAdd;

}
