package com.ibagroup.carrental.endpoint.user;

import com.ibagroup.carrental.dao.model.user.User;
import com.ibagroup.carrental.service.dto.user.UserAuthorizationDto;
import com.ibagroup.carrental.service.dto.user.UserRegistrationDto;
import com.ibagroup.carrental.service.dto.user.UserDto;
import com.ibagroup.carrental.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody UserAuthorizationDto userAuthorizationDto){
        ResponseEntity entity = userService.signIn(userAuthorizationDto);

        return entity;
    }

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(@RequestBody UserRegistrationDto userRegistrationDto){
        ResponseEntity entity = userService.signUp(userRegistrationDto);

        return entity;
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable("userId") Long userId){
        UserDto userDto = userService.findUserById(userId);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByUserName(@RequestParam String userName){
        UserDto userDto = userService.findByUserName(userName);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers(){
        List<UserDto> userDtoList = userService.findAllUsers();

        return ResponseEntity.ok(userDtoList);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserDto userDto){
        User entity = userService.updateUser(userDto);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }

}