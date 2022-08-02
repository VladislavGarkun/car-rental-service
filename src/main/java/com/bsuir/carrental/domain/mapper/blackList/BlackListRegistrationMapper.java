package com.bsuir.carrental.domain.mapper.blackList;

import com.bsuir.carrental.dao.model.blackList.BlackList;
import com.bsuir.carrental.domain.dto.blackList.BlackListRegistrationDto;

public interface BlackListRegistrationMapper {

    BlackList toEntity(BlackListRegistrationDto blackListRegistrationDto);

}