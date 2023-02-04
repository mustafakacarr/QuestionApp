package com.project.questionapp.controllers;

import com.project.questionapp.entities.Like;
import com.project.questionapp.requests.LikeCreateRequest;
import com.project.questionapp.responses.LikeResponse;
import com.project.questionapp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/likes")
public class LikeController {
    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return likeService.getAllLikes(userId, postId);
    }
    @PostMapping
    public Like likeOnPost(@RequestBody LikeCreateRequest newLike){
        return likeService.likeOnPost(newLike);
    }


    @DeleteMapping(path = "/{likeId}")
    public void unlikeOnPost(@PathVariable long likeId){
        likeService.unlikeOnPost(likeId);
    }

    @GetMapping(path = "{likeId}")
    public Like findLikeById(@PathVariable long likeId){
        return likeService.findLike(likeId);
    }

}
