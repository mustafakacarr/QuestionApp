package com.project.questionapp.repos;

import com.project.questionapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findPostByUserId(Long userId);
}
