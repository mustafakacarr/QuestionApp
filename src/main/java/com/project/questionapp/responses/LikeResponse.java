package com.project.questionapp.responses;

import com.project.questionapp.entities.Like;
import lombok.Data;

@Data
public class LikeResponse {
    long id;
    long userId;
    long postId;
    public LikeResponse(Like entity){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.postId=entity.getPost().getId();
    }
}
