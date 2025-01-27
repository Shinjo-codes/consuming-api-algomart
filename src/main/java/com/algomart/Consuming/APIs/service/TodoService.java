package com.algomart.Consuming.APIs.service;

import com.algomart.Consuming.APIs.TodoClient;
import com.algomart.Consuming.APIs.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoClient todoClient;

    @Autowired
    public TodoService(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    public String createTodo(String title){
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);

        return todoClient.createToDo(todo);
    }

    public List<Todo> getAllToDos(){
        return todoClient.findAllTodos();
    }

    public void deleteToDo(Long id){
        todoClient.deleteById(id);
    }

    public Todo updateToDo(Long id, Todo todo){

        return todoClient.updateById(id, todo);
    }
    public Todo getToDoById(Long id){
        return todoClient.findToDoById(id);
    }
    public Todo partiallyUpdateToDo(Long id, Todo todo){
        return todoClient.partiallyUpdateById(id, todo);
    }

}

