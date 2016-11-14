package com.mygaienko.service;

import com.mygaienko.model.Comment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Created by dmygaenko on 14/11/2016.
 */
@Service
public class CommentService {

    @PreAuthorize("#comment.by.name == authentication.name")
    public void editComment(Comment comment) {

    }
}
