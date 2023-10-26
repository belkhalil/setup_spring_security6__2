package com.aba.SpringSecuritySocle.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AppUser {
    @Id
    private String userId;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;
}
