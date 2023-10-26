package com.aba.SpringSecuritySocle.security.service;

import com.aba.SpringSecuritySocle.security.entities.AppRole;
import com.aba.SpringSecuritySocle.security.entities.AppUser;
import com.aba.SpringSecuritySocle.security.repository.AppUserRepository;
import com.aba.SpringSecuritySocle.security.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {


    private AppUserRepository appUserRepository;

    private RoleRepository roleRepository;

    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPass) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) {
            throw new RuntimeException("User Already exists");
        }
        /** if (!password.equals(confirmPass)) {
         throw new RuntimeException("password are not same");
         }
         **/
        appUser = appUser.builder()
                .userId(UUID.randomUUID().toString())
                .password(password)
                .email(email)
                .username(username).build();
        return appUserRepository.save(appUser);
    }


    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = roleRepository.findById(role).orElse(null);
        if (appRole != null) {
            throw new RuntimeException("Role already exists");
        }
        appRole = appRole.builder()
                .role(role)
                .build();
        return roleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = roleRepository.findById(role).get();
        if (appUser != null && appRole != null) {
            appUser.getRoles().add(appRole);
            //it's not mandatory to call save methode because the current methode is transactional so any update
            // on appUser object will be saved to database in the end of transaction
            //appUserRepository.save(appUser);
        } else {
            throw new RuntimeException("User or Role not exists");
        }
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = roleRepository.findById(role).get();
        if (appUser != null && appRole != null) {
            appUser.getRoles().remove(appRole);
            //it's not mandatory to call save methode because the current methode is transactional so any update
            // on appUser object will be saved to database in the end of transaction
            //appUserRepository.save(appUser);
        } else {
            throw new RuntimeException("User or Role not exists");
        }
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
