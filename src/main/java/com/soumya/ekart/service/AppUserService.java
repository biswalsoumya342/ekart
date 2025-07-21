package com.soumya.ekart.service;

import com.soumya.ekart.payload.user.UserLoginDto;
import com.soumya.ekart.payload.user.UserSignupDto;

public interface AppUserService {

    public boolean signupUser(UserSignupDto signupDto);

    public String loginUser(UserLoginDto loginDto);

}
