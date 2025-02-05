package com.algomart.Consuming.APIs;

import com.algomart.Consuming.APIs.model.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "toDoClient", url = "https://jsonplaceholder.typicode.com")
public interface TodoClient {

    @PostMapping("/posts")
    String createToDo(
            @RequestBody Todo todo
            );

    @GetMapping("/posts/{id}")
    Todo findToDoById(@PathVariable("id") Long id
    );

    @GetMapping("/posts")
    List<Todo> findAllTodos(

    );

    @PutMapping("/posts/{id}")
    Todo updateById(@PathVariable("id") Long id,
            @RequestBody Todo todo
    );

    @DeleteMapping("/posts/{id}")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/posts/{id}")
    Todo partiallyUpdateById(@PathVariable("id") Long id,
            @RequestBody Todo todo
    );

}
