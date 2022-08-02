package com.bsuir.carrental.service.authAndReg.impl;

import com.bsuir.carrental.dao.model.user.User;
import com.bsuir.carrental.dao.repository.user.UserRepository;
import com.bsuir.carrental.domain.dto.user.UserRegistrationDto;
import com.bsuir.carrental.domain.mapper.userRole.UserRoleMapper;
import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.user.UserAuthorizationDto;
import com.bsuir.carrental.domain.dto.user.UserDto;
import com.bsuir.carrental.domain.dto.userRole.UserRoleDto;
import com.bsuir.carrental.domain.mapper.user.UserMapper;
import com.bsuir.carrental.domain.mapper.user.UserRegistrationMapper;
import com.bsuir.carrental.service.authAndReg.AuthAndRegService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AuthAndRegServiceImpl implements AuthAndRegService {

    private final static String PASSWORD_PATTERN = "^(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;
    private final UserRegistrationMapper userRegistrationMapper;

    @Override
    public ResponseEntity signIn(UserAuthorizationDto userAuthorizationDto) {
        if(userAuthorizationDto.getUserName().isEmpty() ||
                userAuthorizationDto.getPassword().isEmpty()
        ){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }

        Boolean isUsernameValidAndPasswordMatches = Optional.ofNullable(userRepository.findUserByUserName(userAuthorizationDto.getUserName()))
                .map(user -> user.getPassword().equals(userAuthorizationDto.getPassword()))
                .orElse(false);

        User user = new User();

        if(isUsernameValidAndPasswordMatches){
            user = userRepository.findUserByUserName(userAuthorizationDto.getUserName());
        }

        UserDto userDto = entityToDto(user);

        return isUsernameValidAndPasswordMatches ?
                ResponseEntity.ok(userDto) :
                ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.INVALID_USERNAME_PASSWORD.getMessage()));
    }

    @Override
    public ResponseEntity signUp(UserRegistrationDto userRegistrationDto) {
        if(userRegistrationDto.getFirstName().isEmpty() ||
                userRegistrationDto.getLastName().isEmpty() ||
                userRegistrationDto.getUserName().isEmpty() ||
                userRegistrationDto.getEmail().isEmpty() ||
                userRegistrationDto.getPassword().isEmpty() ||
                userRegistrationDto.getPasswordRepeat().isEmpty() ||
                userRegistrationDto.getPhone().isEmpty()
        ){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }
        if (!Pattern.matches(PASSWORD_PATTERN, userRegistrationDto.getPassword())){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.DONT_USE_REQUIRED_SYMBOLS.getMessage()));
        }
        if(userRepository.findUserByUserName(userRegistrationDto.getUserName()) != null){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.TAKEN_USERNAME.getMessage()));
        }
        if(userRepository.findUserByEmail(userRegistrationDto.getEmail()) != null){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.TAKEN_EMAIL.getMessage()));
        }
        if(!userRegistrationDto.getPassword().equals(userRegistrationDto.getPasswordRepeat())){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.DONT_MATCH_PASSWORDS.getMessage()));
        }

        User user = userRegistrationMapper.toEntity(userRegistrationDto);
        userRepository.save(user);

        UserDto userDto = userMapper.toDto(user);

        return ResponseEntity.ok(userDto);
    }

    private UserDto entityToDto(User user) {
        UserDto userResponseDto = userMapper.toDto(user);
        UserRoleDto userRoleDto = userRoleMapper.toDto(user.getUserRole());
        userResponseDto.setUserRole(userRoleDto);

        return userResponseDto;
    }

}