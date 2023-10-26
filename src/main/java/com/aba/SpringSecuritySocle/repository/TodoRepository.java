package com.aba.SpringSecuritySocle.repository;

import com.aba.SpringSecuritySocle.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
}
