package com.project.questionapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    long id;
    long userId;
    long postId;
    String text;
}
