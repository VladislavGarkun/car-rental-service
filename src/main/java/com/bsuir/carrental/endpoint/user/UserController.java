package com.bsuir.carrental.endpoint.user;

import com.bsuir.carrental.domain.dto.user.UserAuthorizationDto;
import com.bsuir.carrental.domain.dto.user.UserRegistrationDto;
import com.bsuir.carrental.domain.dto.user.UserDto;
import com.bsuir.carrental.service.authAndReg.AuthAndRegService;
import com.bsuir.carrental.service.user.UserService;
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
    private final AuthAndRegService authAndRegService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody UserAuthorizationDto userAuthorizationDto){
        ResponseEntity entity = authAndRegService.signIn(userAuthorizationDto);

        return entity;
    }

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(@RequestBody UserRegistrationDto userRegistrationDto){
        ResponseEntity entity = authAndRegService.signUp(userRegistrationDto);

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
        ResponseEntity entity = userService.updateUser(userDto);

        return entity;
    }

}