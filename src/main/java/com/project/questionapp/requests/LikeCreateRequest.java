package com.project.questionapp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    long id;
    long userId;
    long postId;
}
