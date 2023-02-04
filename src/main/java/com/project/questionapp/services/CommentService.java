package com.project.questionapp.services;

import com.project.questionapp.entities.Comment;
import com.project.questionapp.entities.Post;
import com.project.questionapp.entities.User;
import com.project.questionapp.repos.CommentRepository;
import com.project.questionapp.requests.CommentCreateRequest;
import com.project.questionapp.requests.CommentUpdateRequest;
import com.project.questionapp.responses.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    CommentRepository commentRepository;
    UserService userService;
    PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<CommentResponse> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> list;
        if (userId.isPresent() && postId.isPresent()) {
            list=commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            list=commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            list=commentRepository.findByPostId(postId.get());
        } else {
          list=commentRepository.findAll();
        }
        return list.stream().map(p-> new CommentResponse(p)).collect(Collectors.toList());
    }

    public Comment getCommentById(long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment addComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.findUserById(commentCreateRequest.getUserId());
        Post post=postService.findPost(commentCreateRequest.getPostId());
        if(user!=null && post!=null){
            Comment toComment=new Comment();
            toComment.setId(commentCreateRequest.getId());
            toComment.setPost(post);
            toComment.setUser(user);
            toComment.setText(commentCreateRequest.getText());
            commentRepository.save(toComment);
            return toComment;
        }else {
            System.out.println("error in here");
            System.out.println(commentCreateRequest.getUserId());
            System.out.println(commentCreateRequest.getPostId());
            return null;
        }
    }

    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }


    public Comment updateComment(long commentId, CommentUpdateRequest commentUpdateRequest) {
        Comment comment=getCommentById(commentId);
        if(comment!=null){
            comment.setText(commentUpdateRequest.getText());
            return commentRepository.save(comment);
        }
        return null;
    }
}
