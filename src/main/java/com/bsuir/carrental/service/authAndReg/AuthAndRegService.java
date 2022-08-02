package com.bsuir.carrental.service.authAndReg;

import com.bsuir.carrental.domain.dto.user.UserRegistrationDto;
import com.bsuir.carrental.domain.dto.user.UserAuthorizationDto;
import org.springframework.http.ResponseEntity;

public interface AuthAndRegService {

    ResponseEntity signIn(UserAuthorizationDto userAuthorizationDto);

    ResponseEntity signUp(UserRegistrationDto userRegistrationDto);

}