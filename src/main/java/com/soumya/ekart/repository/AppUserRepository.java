package com.soumya.ekart.repository;

import com.soumya.ekart.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,String> {

    public Optional<AppUser> findByUsername(String username);

}
