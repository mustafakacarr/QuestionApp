package com.project.questionapp.repos;

import com.project.questionapp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
