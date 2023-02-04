package com.project.questionapp.responses;

import com.project.questionapp.entities.Like;
import com.project.questionapp.entities.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    long id;
    long user_id;
    String username;
    String title;
    String text;
    List<LikeResponse> postLikes;
    public PostResponse(Post entity, List<LikeResponse> postLikes){
        this.id=entity.getId();
        this.user_id=entity.getUser().getId();
        this.username=entity.getUser().getUsername();
        this.title=entity.getTitle();
        this.text=entity.getText();
        this.postLikes=postLikes;
    }
}
