package com.mygaienko.service;

import com.mygaienko.dao.CommentDao;
import com.mygaienko.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Created by dmygaenko on 14/11/2016.
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public void createComment(Comment comment){};

    @PreAuthorize("#comment.by.name == authentication.name OR hasRole('ROLE_ADMIN')")
    public void editComment(Comment comment) {

    }

    public void deleteComment(Comment comment){};
}
