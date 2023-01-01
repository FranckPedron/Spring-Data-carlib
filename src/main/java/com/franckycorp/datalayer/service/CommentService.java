package com.franckycorp.datalayer.service;

import com.franckycorp.datalayer.model.Comment;
import com.franckycorp.datalayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
