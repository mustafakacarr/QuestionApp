package com.project.questionapp.controllers;

import com.project.questionapp.entities.Comment;
import com.project.questionapp.requests.CommentCreateRequest;
import com.project.questionapp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return commentService.getAllComments(userId, postId);
    }

    @PostMapping
    public Comment addComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.addComment(commentCreateRequest);
    }

    @GetMapping(path = "/{commentId}")
    public Comment getCommentById(@PathVariable long commentId) {
        return commentService.getCommentById(commentId);
    }
    //  @PutMapping


    @DeleteMapping(path = "/{commentId}")
    public void deleteComment(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
    }

}
