package com.bsuir.carrental.service.user.impl;

import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.dao.model.user.User;
import com.bsuir.carrental.dao.repository.user.UserRepository;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.user.UserDto;
import com.bsuir.carrental.domain.dto.userRole.UserRoleDto;
import com.bsuir.carrental.domain.mapper.user.UserMapper;
import com.bsuir.carrental.domain.mapper.userRole.UserRoleMapper;
import com.bsuir.carrental.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final static String PASSWORD_PATTERN = "^(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).get();

        UserDto userDto = entityToDto(user);

        return userDto;
    }

    @Override
    public UserDto findByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);

        UserDto userDto = entityToDto(user);

        return userDto;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtoList = userMapper.toListDto(users);
        for (int i = 0; i < userDtoList.size(); i++){
            userDtoList.get(i).setUserRole(userRoleMapper.toDto(users.get(i).getUserRole()));
        }

        return userDtoList;
    }

    private UserDto entityToDto(User user) {
        UserDto userResponseDto = userMapper.toDto(user);
        UserRoleDto userRoleDto = userRoleMapper.toDto(user.getUserRole());
        userResponseDto.setUserRole(userRoleDto);

        return userResponseDto;
    }

    @Override
    public ResponseEntity updateUser(UserDto userDto) {
        if(userDto.getFirstName().isEmpty() ||
                userDto.getLastName().isEmpty() ||
                userDto.getUserName().isEmpty() ||
                userDto.getEmail().isEmpty() ||
                userDto.getPassword().isEmpty() ||
                userDto.getPhone().isEmpty()
        ){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }
        if (!Pattern.matches(PASSWORD_PATTERN, userDto.getPassword())){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.DONT_USE_REQUIRED_SYMBOLS.getMessage()));
        }
        if(userRepository.findUserByUserName(userDto.getUserName()) != null &&
                userRepository.findUserByUserName(userDto.getUserName()).getId() != userDto.getId()){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.TAKEN_USERNAME.getMessage()));
        }
        if(userRepository.findUserByEmail(userDto.getEmail()) != null &&
                userRepository.findUserByUserName(userDto.getUserName()).getId() != userDto.getId()){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.TAKEN_EMAIL.getMessage()));
        }

        User user = userMapper.toEntity(userDto);
        user.setUserRole(userRoleMapper.toEntity(userDto.getUserRole()));

        User savedEntity = userRepository.save(user);

        UserDto userResponseDto = userMapper.toDto(savedEntity);
        UserRoleDto userRoleDto = userRoleMapper.toDto(savedEntity.getUserRole());
        userResponseDto.setUserRole(userRoleDto);

        return ResponseEntity.ok(userResponseDto);
    }

}