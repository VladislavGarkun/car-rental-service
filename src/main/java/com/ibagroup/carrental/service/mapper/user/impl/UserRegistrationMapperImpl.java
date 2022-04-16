package com.ibagroup.carrental.service.mapper.user.impl;

import com.ibagroup.carrental.dao.enums.UserRoleEnum;
import com.ibagroup.carrental.dao.model.user.User;
import com.ibagroup.carrental.dao.repository.userRole.UserRoleRepository;
import com.ibagroup.carrental.service.dto.user.UserRegistrationDto;
import com.ibagroup.carrental.service.mapper.user.UserRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationMapperImpl implements UserRegistrationMapper {

    private final UserRoleRepository userRoleRepository;

    @Override
    public User toEntity(UserRegistrationDto userRegistrationDto){
        User user = new User();

        user.setUserRole(userRoleRepository.findUserRoleByRole(UserRoleEnum.USER.toString()));
        user.setUserName(userRegistrationDto.getUserName());
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword());
        user.setPhone(userRegistrationDto.getPhone());

        return user;
    }

}
