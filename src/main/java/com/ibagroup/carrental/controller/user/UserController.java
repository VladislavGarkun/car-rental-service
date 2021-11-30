package com.ibagroup.carrental.controller.user;

import com.ibagroup.carrental.dto.OperationMessageDto;
import com.ibagroup.carrental.dto.authorization.AuthorizationDto;
import com.ibagroup.carrental.dto.regitration.RegistrationDto;
import com.ibagroup.carrental.dto.user.UserDto;
import com.ibagroup.carrental.model.user.User;
import com.ibagroup.carrental.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/")
public class UserController {

    HashMap<String, UserDto> users = new HashMap<>();

    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody UserDto user) {
        User entity = service.addUser(user);

        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable("userId") Long userId){
        User entity = service.getUserById(userId);

        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        List<User> users = service.getAllUsers();

        return users;
    }

    @PutMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user){
        User entity = service.updateUser(user);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "user/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        service.deleteUserById(userId);
    }

    private void saveUser(@RequestBody UserDto user) {
        long latestId = users.size();
        user.setId(latestId);
        users.put(user.getUserName(), user);
    }




    @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUsers(@RequestBody List<UserDto> users){
        users.forEach(this::saveUser);

        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "user/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody AuthorizationDto authorization){
//        Boolean isUsernameValidAndPasswordMatches = Optional.ofNullable(users.get(authorization.getUserName()))
//                .map(user -> user.getPassword().equals(authorization.getPassword())).orElse(false);
//
//        HttpHeaders header = new HttpHeaders();
//        header.add("X-Rate-Limit", "1800");
//        header.add("X-Expires-After", LocalDateTime.now().plusHours(1).toString());
//
//        return isUsernameValidAndPasswordMatches
//                ? ResponseEntity.ok().headers(header).body(new OperationMessageDto("Succesful operation"))
//                : ResponseEntity.badRequest().body(new OperationMessageDto("Invalid username/password supplied"));

        ResponseEntity entity = service.signIn(authorization);

        return entity;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "user/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(@RequestBody RegistrationDto registration){
        ResponseEntity entity = service.SignUp(registration);

        return entity;
    }

    @GetMapping(value = "user/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logout(@RequestParam String userName){
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }
}
