package com.aba.SpringSecuritySocle.security.service;

import com.aba.SpringSecuritySocle.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String[] roles = appUser.getRoles().stream().map(appRole -> appRole.getRole()).toArray(String[]::new);
        UserDetails userDetails = User.withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles).build();

        return userDetails;
    }
}
