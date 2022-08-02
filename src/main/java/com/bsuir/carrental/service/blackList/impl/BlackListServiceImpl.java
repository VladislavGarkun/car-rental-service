package com.bsuir.carrental.service.blackList.impl;

import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.dao.model.blackList.BlackList;
import com.bsuir.carrental.dao.repository.blackList.BlackListRepository;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.blackList.BlackListRegistrationDto;
import com.bsuir.carrental.domain.mapper.blackList.BlackListMapper;
import com.bsuir.carrental.domain.mapper.blackList.BlackListRegistrationMapper;
import com.bsuir.carrental.domain.mapper.user.UserMapper;
import com.bsuir.carrental.domain.mapper.userRole.UserRoleMapper;
import com.bsuir.carrental.service.blackList.BlackListService;
import com.bsuir.carrental.domain.dto.blackList.BlackListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlackListServiceImpl implements BlackListService {

    private final BlackListRepository blackListRepository;
    private final BlackListRegistrationMapper blackListRegistrationMapper;
    private final BlackListMapper blackListMapper;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    @Override
    public ResponseEntity addToBlackList(BlackListRegistrationDto blackListRegistrationDto) {
        if (blackListRegistrationDto.getReason().isEmpty()){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }

        BlackList blackList = blackListRegistrationMapper.toEntity(blackListRegistrationDto);

        BlackList savedEntity = blackListRepository.save(blackList);

        BlackListDto blackListDto = blackListMapper.toDto(savedEntity);
        blackListDto.setUser(userMapper.toDto(savedEntity.getUser()));
        blackListDto.getUser().setUserRole(userRoleMapper.toDto(savedEntity.getUser().getUserRole()));

        return ResponseEntity.ok(blackListDto);
    }

    @Override
    public BlackListDto findBlackListByUserId(Long userId) {
        BlackList blackList = blackListRepository.findDistinctFirstByUserId(userId);

        BlackListDto blackListDto = blackListMapper.toDto(blackList);
        blackListDto.setUser(userMapper.toDto(blackList.getUser()));
        blackListDto.getUser().setUserRole(userRoleMapper.toDto(blackList.getUser().getUserRole()));

        return blackListDto;
    }

    @Override
    public List<BlackListDto> findAllBlackList() {
        List<BlackList> blackListList =  blackListRepository.findAll();

        List<BlackListDto> blackListDtoList = blackListMapper.toListDto(blackListList);
        for (int i = 0; i < blackListDtoList.size(); i++){
            blackListDtoList.get(i).setUser(userMapper.toDto(blackListList.get(i).getUser()));
            blackListDtoList.get(i).getUser().setUserRole(userRoleMapper.toDto(blackListList.get(i).getUser().getUserRole()));        }

        return blackListDtoList;
    }

    @Override
    public void deleteBlackListById(Long blackListId) {
        blackListRepository.deleteById(blackListId);
    }

}