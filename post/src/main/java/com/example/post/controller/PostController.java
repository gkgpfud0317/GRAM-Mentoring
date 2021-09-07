package com.example.post.controller;

import com.example.post.payload.request.CreatePostRequest;
import com.example.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public void createPost(@RequestBody CreatePostRequest request) {
        postService.savePost(request);
    }

}
