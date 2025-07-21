package com.soumya.ekart.controller;

import com.soumya.ekart.payload.ApiErrorResponse;
import com.soumya.ekart.payload.ApiResponse;
import com.soumya.ekart.payload.user.UserLoginDto;
import com.soumya.ekart.payload.user.UserSignupDto;
import com.soumya.ekart.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<?> userSignup(@RequestBody UserSignupDto signupDto){
        boolean status = appUserService.signupUser(signupDto);
        if (status) return new ResponseEntity<>(
                new ApiResponse(
                        LocalDateTime.now(),
                        "Signup Successessful",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
        else return new ResponseEntity<>(
                new ApiErrorResponse(
                        LocalDateTime.now(),
                        "Unknown Error Occured, Try Again!",
                        HttpStatus.INTERNAL_SERVER_ERROR.value()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginDto loginDto) {
        return appUserService.loginUser(loginDto);
    }
}
