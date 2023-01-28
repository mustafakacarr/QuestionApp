package com.project.questionapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
    long id;
    String text;
    String title;
    long userId;
}
