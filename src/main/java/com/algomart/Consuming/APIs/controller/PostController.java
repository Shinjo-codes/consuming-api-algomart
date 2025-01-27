package com.algomart.Consuming.APIs.controller;

import com.algomart.Consuming.APIs.model.Post;
import com.algomart.Consuming.APIs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public String createPost(@RequestBody Post post){
        return postService.createPost(post.getTitle(), post.getBody());
    }

    @GetMapping("/posts")
    public List<Post> findPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PutMapping("/posts/{id}")
    public Post updatePostById(@PathVariable Long id, @RequestBody Post post){
        return postService.updatePost(id, post);
    }

    @PatchMapping("/posts/{id}")
    public Post partiallyUpdatePostById(@PathVariable Long id, @RequestBody Post post){
        return postService.partiallyUpdatePost(id, post);
    }

}
