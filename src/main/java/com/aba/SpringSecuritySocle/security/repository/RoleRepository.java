package com.aba.SpringSecuritySocle.security.repository;

import com.aba.SpringSecuritySocle.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, String> {

}
