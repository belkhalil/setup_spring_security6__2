package com.aba.SpringSecuritySocle.service;

import com.aba.SpringSecuritySocle.model.TodoEntity;
import com.aba.SpringSecuritySocle.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    @Override
    public Optional<TodoEntity> add(TodoEntity todoEntity) {
        todoEntity.setId(UUID.randomUUID());
        return Optional.of(todoRepository.save(todoEntity));
    }

    @Override
    public Optional<TodoEntity> update(UUID oldTodoId, TodoEntity newTodo) {
        Optional<TodoEntity> todoEntity = todoRepository.findById(oldTodoId);
        if(todoEntity.isPresent()){
            newTodo.setId(oldTodoId);

        return Optional.of(todoRepository.saveAndFlush(newTodo));
        }
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {
         todoRepository.deleteById(id);
    }

    @Override
    public List<TodoEntity> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<TodoEntity> getOne(UUID uuid) {
        return todoRepository.findById(uuid);
    }
}
