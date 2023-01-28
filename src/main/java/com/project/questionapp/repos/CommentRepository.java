package com.project.questionapp.repos;

import com.project.questionapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserIdAndPostId(long userId, long postId);

    List<Comment> findByUserId(long userId);
    List<Comment> findByPostId(long postId);
}
