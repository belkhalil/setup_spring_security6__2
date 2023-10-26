package com.aba.SpringSecuritySocle.controller;

import com.aba.SpringSecuritySocle.model.TodoEntity;
import com.aba.SpringSecuritySocle.service.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
@Tag(name = "Todos")
public class TodoController {

    private final TodoService todoService;

    /**
     * get All
     *
     * @return
     */
    @GetMapping("/todos")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<TodoEntity> getAll() {
        return todoService.getAll();
    }

    /**
     * @param todoEntity
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public TodoEntity add(@RequestBody TodoEntity todoEntity) {
        return todoService.add(todoEntity).get();
    }

    @PutMapping("/update/{oldTodoId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TodoEntity update(@PathVariable("oldTodoId") UUID oldTodoId, @RequestBody TodoEntity nrwTodo) {
        return todoService.update(oldTodoId, nrwTodo).get();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable("id") UUID id){
        todoService.delete(id);
    }
}
