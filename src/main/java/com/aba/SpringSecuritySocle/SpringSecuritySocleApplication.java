package com.aba.SpringSecuritySocle;

import com.aba.SpringSecuritySocle.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecuritySocleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySocleApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService) {
        return args -> {
            accountService.addNewRole("USER");
            accountService.addNewRole("ADMIN");
            accountService.addNewUser("user1", passwordEncoder().encode("1234"), "mail@user.com", "1234");
            accountService.addNewUser("user2", passwordEncoder().encode("1234"), "mail@user2.com", "1234");
            accountService.addNewUser("admin", passwordEncoder().encode("1234"), "mail@admin.com", "1234");

            accountService.addRoleToUser("user1", "USER");
            accountService.addRoleToUser("user2", "USER");
            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("admin", "USER");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


