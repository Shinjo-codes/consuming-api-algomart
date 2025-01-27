package com.algomart.Consuming.APIs;

import com.algomart.Consuming.APIs.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "postClient", url = "https://jsonplaceholder.typicode.com")
public interface PostClient {

    @PostMapping("/posts")
    String createPost(@RequestBody Post post);

    @GetMapping("/posts/{id}")
    Post findPostById(@PathVariable Long id);

    @GetMapping("/posts")
    List<Post> getPosts();

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id);

    @PutMapping("/posts/{id}")
    Post updatePost(@PathVariable("id") Long id,
                      @RequestBody Post post);

    @PatchMapping("/posts/{id}")
    Post partiallyUpdatePost(@PathVariable("id") Long id,
                               @RequestBody Post post);

}
