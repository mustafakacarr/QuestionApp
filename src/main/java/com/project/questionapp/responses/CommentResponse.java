package com.project.questionapp.responses;

import com.project.questionapp.entities.Comment;
import lombok.Data;

@Data
public class CommentResponse {
    long id;
    long userId;
    String username;
    String text;

    public CommentResponse(Comment entity){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.username=entity.getUser().getUsername();
        this.text=entity.getText();
    }
}
