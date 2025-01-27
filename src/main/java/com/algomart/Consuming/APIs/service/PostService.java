package com.algomart.Consuming.APIs.service;

import com.algomart.Consuming.APIs.PostClient;
import com.algomart.Consuming.APIs.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostClient postClient;

    @Autowired
    public PostService(PostClient postClient) {
        this.postClient = postClient;
    }

    public String createPost(String title, String body){
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        return postClient.createPost(post);
    }

    public List<Post> getAllPosts(){
        return postClient.getPosts();
    }

    public Post updatePost(Long id, Post post){
        return postClient.updatePost(id,post);
    }

    public void deletePost(Long id){
        postClient.deletePost(id);
    }

    public Post partiallyUpdatePost(Long id, Post post){
        return postClient.partiallyUpdatePost(id, post);
    }

    public Post getPostById(Long id){
        return postClient.findPostById(id);
    }

}
