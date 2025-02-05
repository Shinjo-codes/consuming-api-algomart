package com.algomart.Consuming.APIs;

import com.algomart.Consuming.APIs.model.Todo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoClientIntegrationTest {

    @Autowired
    private TodoClient todoClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testFindToDoById() {
        Todo todo = todoClient.findToDoById(1L);
        assertNotNull(todo);
        assertEquals(1L, todo.getId());
    }

    @Test
    void testFindAllTodos() {
        List<Todo> todos = todoClient.findAllTodos();
        assertFalse(todos.isEmpty());
    }

    @Test
    void testCreateToDo() throws JsonProcessingException {
        Todo newTodo = new Todo();
        newTodo.setId(1L);
        newTodo.setTitle("Test Title");
        newTodo.setCompleted(newTodo.isCompleted());

        String response = todoClient.createToDo(newTodo);
        assertNotNull(response);

        // Parse response to verify fields
        Todo createdTodo = objectMapper.readValue(response, Todo.class);
        assertEquals("Test Title", createdTodo.getTitle());
        assertEquals(101, createdTodo.getId());
        assertFalse(createdTodo.isCompleted());
    }

    @Test
    void testUpdateById() {
        Long id = 1L;
        Todo updatedTodo = new Todo();
        updatedTodo.setTitle("Updated Title");
        updatedTodo.setCompleted(false);
        updatedTodo.setId(1L);

        Todo result = todoClient.updateById(id, updatedTodo);
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Title", result.getTitle());
    }

    @Test
    void testPartiallyUpdateById() {
        Long id = 1L;
        Todo updates = new Todo();
        updates.setTitle("Patched Title");

        Todo result = todoClient.partiallyUpdateById(id, updates);

























































        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Patched Title", result.getTitle());
    }

    @Test
    void testDeleteById() {
        assertDoesNotThrow(() -> todoClient.deleteById(1L));
    }
}