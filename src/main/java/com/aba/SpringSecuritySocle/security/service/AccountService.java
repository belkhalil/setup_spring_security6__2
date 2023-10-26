package com.aba.SpringSecuritySocle.security.service;

import com.aba.SpringSecuritySocle.security.entities.AppRole;
import com.aba.SpringSecuritySocle.security.entities.AppUser;

public interface AccountService {

    AppUser addNewUser(String username, String password, String email, String confirmPass);

    AppRole addNewRole(String role);

    void addRoleToUser(String username, String role);

    void removeRoleFromUser(String username, String role);

    AppUser loadUserByUsername(String username);


}
