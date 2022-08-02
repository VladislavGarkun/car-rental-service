package com.bsuir.carrental.domain.mapper.user.impl;

import com.bsuir.carrental.dao.model.user.User;
import com.bsuir.carrental.domain.dto.user.UserRegistrationDto;
import com.bsuir.carrental.dao.repository.userRole.UserRoleRepository;
import com.bsuir.carrental.domain.mapper.user.UserRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationMapperImpl implements UserRegistrationMapper {

    private final static String USER_ROLE = "USER";

    private final UserRoleRepository userRoleRepository;

    @Override
    public User toEntity(UserRegistrationDto userRegistrationDto){
        User user = new User();

        user.setUserRole(userRoleRepository.findUserRoleByRole(USER_ROLE));
        user.setUserName(userRegistrationDto.getUserName());
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword());
        user.setPhone(userRegistrationDto.getPhone());

        return user;
    }

}
