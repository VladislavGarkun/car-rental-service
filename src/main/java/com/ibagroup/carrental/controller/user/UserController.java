package com.ibagroup.carrental.controller.user;

import com.ibagroup.carrental.dto.OperationMessageDto;
import com.ibagroup.carrental.dto.authorization.AuthorizationDto;
import com.ibagroup.carrental.dto.car.CarDto;
import com.ibagroup.carrental.dto.user.UserDto;
import org.springframework.http.HttpHeaders;
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

    @PostMapping(value = "user", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody UserDto user) {
        saveUser(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "users", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUsers(@RequestBody List<UserDto> users){
        users.forEach(this::saveUser);

        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @PostMapping(value = "user/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity login(@RequestBody AuthorizationDto authorization){
        Boolean isUsernameValidAndPasswordMatches = Optional.ofNullable(users.get(authorization.getUserName()))
                .map(user -> user.getPassword().equals(authorization.getPassword())).orElse(false);

        HttpHeaders header = new HttpHeaders();
        header.add("X-Rate-Limit", "1800");
        header.add("X-Expires-After", LocalDateTime.now().plusHours(1).toString());

        return isUsernameValidAndPasswordMatches
                ? ResponseEntity.ok().headers(header).body(new OperationMessageDto("Succesful operation"))
                : ResponseEntity.badRequest().body(new OperationMessageDto("Invalid username/password supplied"));
    }

    @GetMapping(value = "user/logout", produces = "application/json")
    public ResponseEntity logout(@RequestParam String userName){
        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @GetMapping(value = "user/{username}", produces = "application/json")
    public ResponseEntity getUserByName(@PathVariable String username){
        Optional<UserDto> foundUser = Optional.ofNullable(users.get(username));

        return foundUser.isPresent() ? ResponseEntity.ok(foundUser.get())
                : ResponseEntity.noContent().build();
    }

    @PutMapping(value = "user/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity userUpdate(@PathVariable String username, @RequestBody UserDto user){
        users.put(username, user);

        return ResponseEntity.ok(new OperationMessageDto("Successful operation"));
    }

    @DeleteMapping(value = "user/{username}", produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable String username){
        UserDto user = users.remove(username);

        return ResponseEntity.ok(user);
    }

    private void saveUser(@RequestBody UserDto user) {
        long latestId = users.size();
        user.setId(latestId);
        users.put(user.getUserName(), user);
    }
}
