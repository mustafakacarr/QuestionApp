package com.project.questionapp.services;

import com.project.questionapp.entities.Post;
import com.project.questionapp.entities.User;
import com.project.questionapp.repos.PostRepository;
import com.project.questionapp.requests.PostCreateRequest;
import com.project.questionapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()) return postRepository.findPostByUserId(userId.get());
        else return postRepository.findAll();
    }
    public Post findPost(long postId) {
        return postRepository.findById(postId).orElse(null);
    }
    public Post createPost(PostCreateRequest newPostRequest) {
        User user=userService.findUserById(newPostRequest.getUserId());
        if(user==null)return null;
            Post toSave=new Post();
            toSave.setId(newPostRequest.getId());
            toSave.setText(newPostRequest.getText());
            toSave.setTitle(newPostRequest.getTitle());
            toSave.setUser(user);
        return postRepository.save(toSave);
    }


    public Post updatePost(long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent())
        {
         Post toUpdate=post.get();
         toUpdate.setTitle(postUpdateRequest.getTitle());
         toUpdate.setText(postUpdateRequest.getText());
         return postRepository.save(toUpdate);
        }
        return null;
    }

    public void deletePostById(long postId) {
        postRepository.deleteById(postId);
    }
}
