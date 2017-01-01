package com.mygaienko.controller;

import com.mygaienko.model.Comment;
import com.mygaienko.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by enda1n on 01.01.2017.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    public void createComment(Comment comment){}

    public void editComment(Comment comment){}

    public void deleteComment(Comment comment){}
}
