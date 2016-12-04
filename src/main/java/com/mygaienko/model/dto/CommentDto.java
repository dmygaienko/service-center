package com.mygaienko.model.dto;

import com.mygaienko.model.Comment;
import com.mygaienko.model.Work;
import com.mygaienko.model.WorkStatus;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by enda1n on 03.12.2016.
 */
@Data
public class CommentDto {

    private Long id;
    private String content;
    private String username;

    public CommentDto(Comment comment) {
        id = comment.getId();
        content = comment.getContent();
        username = comment.getBy().name();
    }
}
