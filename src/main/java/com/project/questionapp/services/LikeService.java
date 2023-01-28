package com.project.questionapp.services;

import com.project.questionapp.entities.Like;
import com.project.questionapp.entities.Post;
import com.project.questionapp.entities.User;
import com.project.questionapp.repos.LikeRepository;
import com.project.questionapp.requests.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    LikeRepository likeRepository;
    UserService userService;
    PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());
        } else {
            return likeRepository.findAll();
        }
    }


    public Like likeOnPost(LikeCreateRequest newLike) {
        User user = userService.findUserById(newLike.getUserId());
        Post post = postService.findPost(newLike.getPostId());
        System.out.println(user.getId());
        System.out.println(post.getId());
        if (user != null && post != null) {
            Like toLike = new Like();
            toLike.setId(newLike.getId());
            toLike.setUser(user);
            toLike.setPost(post);
            return likeRepository.save(toLike);
        } else {
            System.out.println("error in here");
            return null;
        }
    }

    public void unlikeOnPost(long likeId) {
        likeRepository.deleteById(likeId);
    }

    public Like findLike(long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }
}
