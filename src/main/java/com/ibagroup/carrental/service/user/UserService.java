package com.ibagroup.carrental.service.user;

import com.ibagroup.carrental.dto.OperationMessageDto;
import com.ibagroup.carrental.dto.authorization.AuthorizationDto;
import com.ibagroup.carrental.dto.regitration.RegistrationDto;
import com.ibagroup.carrental.dto.user.UserDto;
import com.ibagroup.carrental.model.user.User;
import com.ibagroup.carrental.model.userRole.UserRole;
import com.ibagroup.carrental.model.userRole.UserRoleEnum;
import com.ibagroup.carrental.repo.user.UserRepo;
import com.ibagroup.carrental.repo.userRole.UserRoleRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo repo;

    private final UserRoleRepo userRoleRepo;

    public UserService(UserRepo repo, UserRoleRepo userRoleRepo){
        this.repo = repo;
        this.userRoleRepo = userRoleRepo;
    }

    public User addUser(UserDto user) {
        User entity = new User();
        entity.setUserRole(userRoleRepo.findById(user.getUserRoleId()).get());
        entity.setUserName(user.getUserName());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setPhone(user.getPhone());

        repo.save(entity);

        return entity;
    }

    public User getUserById(Long id) {
        return repo.findById(id).get();
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User updateUser(User user) {
        return  repo.save(user);
    }

    public void deleteUserById(Long userId) {
        repo.deleteById(userId);
    }

    public ResponseEntity signIn(AuthorizationDto authorization) {
        Boolean isUsernameValidAndPasswordMatches = Optional.ofNullable(repo.findByUserName(authorization.getUserName()))
                .map(user -> user.getPassword().equals(authorization.getPassword())).orElse(false);

        User user = new User();

        if(isUsernameValidAndPasswordMatches){
            user = repo.findByUserName(authorization.getUserName());
        }

        return isUsernameValidAndPasswordMatches ?
                ResponseEntity.ok(user) :
                ResponseEntity.badRequest().body(new OperationMessageDto("Invalid username/password supplied"));
    }

    public ResponseEntity SignUp(RegistrationDto registration) {
        User entity = new User();

        entity.setUserRole(userRoleRepo.findUserRoleByRole(UserRoleEnum.USER.toString()));
        entity.setUserName(registration.getUserName());
        entity.setFirstName(registration.getFirstName());
        entity.setLastName(registration.getLastName());
        entity.setEmail(registration.getEmail());
        entity.setPassword(registration.getPassword());
        entity.setPhone(registration.getPhone());

        repo.save(entity);

        return ResponseEntity.ok(entity);
    }
}
