package com.algomart.Consuming.APIs;

import com.algomart.Consuming.APIs.model.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "toDoClient", url = "https://jsonplaceholder.typicode.com/")
public interface ApiClient {

    @PostMapping("/posts")
    String createToDo(
            @RequestBody Todo todo
            );

    @GetMapping("/id")
    String findToDoById(
            @RequestBody Todo todo
    );

    @GetMapping("/todos")
    String findAllTodos(
            @RequestBody Todo todo
    );

}
