package com.bsuir.carrental.domain.mapper.blackList.impl;

import com.bsuir.carrental.domain.mapper.blackList.BlackListRegistrationMapper;
import com.bsuir.carrental.dao.model.blackList.BlackList;
import com.bsuir.carrental.dao.repository.user.UserRepository;
import com.bsuir.carrental.domain.dto.blackList.BlackListRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BlackListRegistrationMapperImpl implements BlackListRegistrationMapper {

    private final UserRepository userRepository;

    @Override
    public BlackList toEntity(BlackListRegistrationDto blackListRegistrationDto){
        BlackList blackList = new BlackList();
        blackList.setUser(userRepository.findById(blackListRegistrationDto.getUserId()).get());
        blackList.setReason(blackListRegistrationDto.getReason());
        blackList.setDateOfAdd(LocalDate.now());

        return blackList;
    }

}