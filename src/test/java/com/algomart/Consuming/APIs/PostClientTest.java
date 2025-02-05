package com.algomart.Consuming.APIs;

import com.algomart.Consuming.APIs.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostClientTest {

    @Autowired
    private PostClient postClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testFindPostById() {
        Post post = postClient.findPostById(1L);
        assertNotNull(post);
        assertEquals(1L, post.getId());
    }

    @Test
    void testFindAllPost() {
        List<Post> posts = postClient.getPosts();
        assertFalse(posts.isEmpty());
    }

    @Test
    void testCreatePost() throws JsonProcessingException {
        Post newPost = new Post();
        newPost.setId(1L);
        newPost.setTitle("Test Title");
        newPost.setBody("Still testing body");

        String response = postClient.createPost(newPost);
        assertNotNull(response);

        // Parse response to verify fields
        Post createdPost = objectMapper.readValue(response, Post.class);
        assertEquals("Test Title", createdPost.getTitle());
        assertEquals(101, createdPost.getId());
        assertEquals("Still testing body", createdPost.getBody());
    }

    @Test
    void testUpdateById() {
        Long id = 1L;
        Post updatedPost = new Post();
        updatedPost.setTitle("Updated Title");
        updatedPost.setBody("Quck updates");
        updatedPost.setId(1L);

        Post result = postClient.updatePost(id, updatedPost);
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Title", result.getTitle());
    }

    @Test
    void testPartiallyUpdateById() {
        Long id = 1L;
        Post updates = new Post();
        updates.setTitle("Patched Title");

        Post result = postClient.partiallyUpdatePost(id, updates);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Patched Title", result.getTitle());
    }

    @Test
    void testDeleteById() {
        assertDoesNotThrow(() -> postClient.deletePost(1L));
    }
}