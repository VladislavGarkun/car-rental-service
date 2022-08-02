package com.bsuir.carrental.service.blackList;

import com.bsuir.carrental.domain.dto.blackList.BlackListRegistrationDto;
import com.bsuir.carrental.domain.dto.blackList.BlackListDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlackListService {

    ResponseEntity addToBlackList(BlackListRegistrationDto blackListRegistrationDto);

    BlackListDto findBlackListByUserId(Long userId);

    List<BlackListDto> findAllBlackList();

    void deleteBlackListById(Long blackListId);

}