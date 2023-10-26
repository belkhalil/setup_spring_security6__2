package com.aba.SpringSecuritySocle.service;

import com.aba.SpringSecuritySocle.model.TodoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoService {
    public Optional<TodoEntity> add(TodoEntity todoEntity);
    public Optional<TodoEntity> update(UUID oldTodoId, TodoEntity newTodo);

    public void delete(UUID id);
    public List<TodoEntity> getAll();
    public Optional<TodoEntity> getOne(UUID uuid);
}
