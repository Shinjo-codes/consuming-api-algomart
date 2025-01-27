package com.algomart.Consuming.APIs;

import com.algomart.Consuming.APIs.model.Todo;
import feign.Feign;
import feign.gson.GsonDecoder; // Import GsonDecoder from feign-gson
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoClientTest {

    private static MockWebServer mockWebServer;
    private static TodoClient todoClient;
    private static final com.google.gson.Gson gson = new com.google.gson.Gson();

    @BeforeAll
    static void setUp() throws IOException {
        // Start MockWebServer
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        // Create Feign Client pointing to MockWebServer
        todoClient = Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new GsonDecoder())  // Use GsonDecoder from feign-gson
                .target(TodoClient.class, mockWebServer.url("/").toString());
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void testFindAllTodos() throws Exception {
        // Mock Response
        String responseBody = gson.toJson(
                List.of(new Todo(1L, "Test Todo 1", false), new Todo(2L, "Test Todo 2", true))
        );
        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json"));

        // Call Feign Client
        List<Todo> todos = todoClient.findAllTodos();

        // Assertions
        assertThat(todos).hasSize(2);
        assertThat(todos.get(0).getId()).isEqualTo(1L);
        assertThat(todos.get(0).getTitle()).isEqualTo("Test Todo 1");
    }

    @Test
    void testFindToDoById() throws Exception {
        // Mock Response
        Todo expectedTodo = new Todo(1L, "Test Todo 1", false);
        String responseBody = gson.toJson(expectedTodo);
        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json"));

        // Call Feign Client
        Todo todo = todoClient.findToDoById(1L);

        // Assertions
        assertThat(todo.getId()).isEqualTo(1L);
        assertThat(todo.getTitle()).isEqualTo("Test Todo 1");
        assertThat(todo.isCompleted()).isFalse();
    }

    @Test
    void testCreateToDo() throws Exception {
        // Mock Response
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(201)
                .setBody("Created"));

        // Call Feign Client
        String response = todoClient.createToDo(new Todo(3L, "New Todo", false));

        // Assertions
        assertThat(response).isEqualTo("Created");
    }

    @Test
    void testUpdateById() throws Exception {
        // Mock Response
        Todo updatedTodo = new Todo(1L, "Updated Todo", true);
        String responseBody = gson.toJson(updatedTodo);
        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json"));

        // Call Feign Client
        Todo response = todoClient.updateById(1L, new Todo(1L, "Updated Todo", true));

        // Assertions
        assertThat(response.getTitle()).isEqualTo("Updated Todo");
        assertThat(response.isCompleted()).isTrue();
    }

    @Test
    void testDeleteById() throws InterruptedException {
        // Mock Response
        mockWebServer.enqueue(new MockResponse().setResponseCode(204));

        // Call Feign Client
        todoClient.deleteById(1L);

        // Assertions
        assertThat(mockWebServer.takeRequest().getMethod()).isEqualTo("DELETE");
    }

    @Test
    void testPartiallyUpdateById() throws Exception {
        // Mock Response
        Todo partiallyUpdatedTodo = new Todo(1L, "Partially Updated Todo", true);
        String responseBody = gson.toJson(partiallyUpdatedTodo);
        mockWebServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json"));

        // Call Feign Client
        Todo response = todoClient.partiallyUpdateById(1L, new Todo(1L, "Partially Updated Todo", true));

        // Assertions
        assertThat(response.getTitle()).isEqualTo("Partially Updated Todo");
        assertThat(response.isCompleted()).isTrue();
    }
}
