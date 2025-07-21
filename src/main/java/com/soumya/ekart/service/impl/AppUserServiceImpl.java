package com.soumya.ekart.service.impl;

import com.soumya.ekart.model.user.AppUser;
import com.soumya.ekart.payload.user.UserLoginDto;
import com.soumya.ekart.payload.user.UserSignupDto;
import com.soumya.ekart.repository.AppUserRepository;
import com.soumya.ekart.security.jwt.JwtService;
import com.soumya.ekart.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;
    private final ModelMapper mapper;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Override
    public boolean signupUser(UserSignupDto signupDto) {
        AppUser user = mapper.map(signupDto,AppUser.class);
        user.setRole("USER");
        user.setCreatedAt(LocalDateTime.now());
        AppUser isSaved = userRepository.save(user);
        return isSaved!=null;
    }

    @Override
    public String loginUser(UserLoginDto loginDto) {
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        authenticationManager.authenticate(authentication);
        return jwtService.generateToken(loginDto.getUsername());
    }

}
