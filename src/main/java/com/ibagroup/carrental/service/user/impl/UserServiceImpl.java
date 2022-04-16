package com.ibagroup.carrental.service.user.impl;

import com.ibagroup.carrental.dao.model.user.User;
import com.ibagroup.carrental.dao.repository.user.UserRepository;
import com.ibagroup.carrental.service.dto.OperationMessageDto;
import com.ibagroup.carrental.service.dto.user.UserAuthorizationDto;
import com.ibagroup.carrental.service.dto.user.UserDto;
import com.ibagroup.carrental.service.dto.user.UserRegistrationDto;
import com.ibagroup.carrental.service.dto.userRole.UserRoleDto;
import com.ibagroup.carrental.service.mapper.user.UserMapper;
import com.ibagroup.carrental.service.mapper.user.UserRegistrationMapper;
import com.ibagroup.carrental.service.mapper.userRole.UserRoleMapper;
import com.ibagroup.carrental.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final static String EMPTY_FIELDS = "You are didn't fill in all required fields";
    private final static String TAKEN_USERNAME = "This username is already taken";
    private final static String TAKEN_EMAIL = "This email is already taken";
    private final static String DONT_MATCH_PASSWORDS = "Entered passwords are don't match";

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;
    private final UserRegistrationMapper userRegistrationMapper;

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
            userDtoList.get(i).setUserRoleDto(userRoleMapper.toDto(users.get(i).getUserRole()));
        }

        return userDtoList;
    }

    @Override
    public ResponseEntity signIn(UserAuthorizationDto userAuthorizationDto) {
        if(userAuthorizationDto.getUserName().isEmpty() ||
                userAuthorizationDto.getPassword().isEmpty()
        ){
            return ResponseEntity.badRequest().body(new OperationMessageDto("You are didn't fill in all required fields"));
        }

        Boolean isUsernameValidAndPasswordMatches = Optional.ofNullable(userRepository.findUserByUserName(userAuthorizationDto.getUserName()))
                .map(user -> user.getPassword().equals(userAuthorizationDto.getPassword())).orElse(false);

        User user = new User();

        if(isUsernameValidAndPasswordMatches){
            user = userRepository.findUserByUserName(userAuthorizationDto.getUserName());
        }

        UserDto userDto = entityToDto(user);

        return isUsernameValidAndPasswordMatches ?
                ResponseEntity.ok(userDto) :
                ResponseEntity.badRequest().body(new OperationMessageDto("Invalid username/password supplied"));
    }

    private UserDto entityToDto(User user) {
        UserDto userResponseDto = userMapper.toDto(user);
        UserRoleDto userRoleDto = userRoleMapper.toDto(user.getUserRole());
        userResponseDto.setUserRoleDto(userRoleDto);

        return userResponseDto;
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
            return ResponseEntity.badRequest().body(new OperationMessageDto(EMPTY_FIELDS));
        }
        if(userRepository.findUserByUserName(userRegistrationDto.getUserName()) != null){
            return ResponseEntity.badRequest().body(new OperationMessageDto(TAKEN_USERNAME));
        }
        if(userRepository.findUserByEmail(userRegistrationDto.getEmail()) != null){
            return ResponseEntity.badRequest().body(new OperationMessageDto(TAKEN_EMAIL));
        }
        if(!userRegistrationDto.getPassword().equals(userRegistrationDto.getPasswordRepeat())){
            return ResponseEntity.badRequest().body(new OperationMessageDto(DONT_MATCH_PASSWORDS));
        }

        User user = userRegistrationMapper.toEntity(userRegistrationDto);
        userRepository.save(user);

        UserDto userDto = userMapper.toDto(user);

        return ResponseEntity.ok(userDto);
    }

    @Override
    public User updateUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setUserRole(userRoleMapper.toEntity(userDto.getUserRoleDto()));

        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

}
