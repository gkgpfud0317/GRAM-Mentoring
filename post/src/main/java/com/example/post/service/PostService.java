package com.example.post.service;

import com.example.post.payload.request.CreatePostRequest;
import com.example.post.payload.response.PostResponse;
import com.example.post.repository.Post;
import com.example.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 저장
    public void savePost(CreatePostRequest createPostRequest) {
        Post post = new Post(null, createPostRequest.getTitle(), createPostRequest.getContent(), LocalDateTime.now());
        postRepository.save(post);
    }

    // 목록
    public List<PostResponse> getPost() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            PostResponse postResponse = new PostResponse(post.getTitle(), post.getContent());
            postResponses.add(postResponse);
        }
        return postResponses;
    }
}

