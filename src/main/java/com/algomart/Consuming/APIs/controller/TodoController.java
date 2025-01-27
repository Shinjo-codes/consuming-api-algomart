package com.algomart.Consuming.APIs.controller;

import com.algomart.Consuming.APIs.model.Todo;
import com.algomart.Consuming.APIs.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public String createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo.getTitle());
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteToDo(id);
    }

    @GetMapping
    public List<Todo> getAllToDos(){
        return todoService.getAllToDos();
    }

    @PutMapping("/{id}")
    public Todo updateToDos(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateToDo(id, todo);
    }

    @PatchMapping("/{id}")
    public Todo partiallyUpdateToDos(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.partiallyUpdateToDo(id, todo);
    }

    @GetMapping("/{id}")
    public Todo getToDo(@PathVariable Long id){
        return todoService.getToDoById(id);
    }

}
