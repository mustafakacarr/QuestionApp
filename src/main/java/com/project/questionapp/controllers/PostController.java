package com.project.questionapp.controllers;

import com.project.questionapp.entities.Post;
import com.project.questionapp.requests.PostCreateRequest;
import com.project.questionapp.requests.PostUpdateRequest;
import com.project.questionapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/posts")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
       return postService.getAllPosts(userId);
    }
    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createPost(newPostRequest);
    }
    @GetMapping(path = "/{postId}")
    public Post findPost(@PathVariable long postId){
        return postService.findPost(postId);
    }
    @PutMapping(path = "/{postId}")
    public Post updatePost(@PathVariable long postId,@RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updatePost(postId,postUpdateRequest);
    }

    @DeleteMapping(path = "/{postId}")

    public void deletePostById(@PathVariable long postId){
         postService.deletePostById(postId);
    }



}
