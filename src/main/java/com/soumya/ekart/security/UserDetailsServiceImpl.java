package com.soumya.ekart.security;

import com.soumya.ekart.exception.ResourceNotFoundException;
import com.soumya.ekart.model.user.AppUser;
import com.soumya.ekart.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository repo;

    public UserDetailsServiceImpl(AppUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.findByUsername(username).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "Seller",
                        "UserName",
                        username
                )
        );
        return new UserDetailsImpl(user);
    }
}
