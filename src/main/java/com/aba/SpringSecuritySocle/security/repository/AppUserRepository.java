package com.aba.SpringSecuritySocle.security.repository;

import com.aba.SpringSecuritySocle.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);

}
