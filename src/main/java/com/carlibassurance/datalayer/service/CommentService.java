package com.carlibassurance.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlibassurance.datalayer.model.Comment;
import com.carlibassurance.datalayer.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public Iterable<Comment> getComments(){
		return this.commentRepository.findAll();
	}
	
	public Optional<Comment> getComment(Integer comment_id){
		return this.commentRepository.findById(comment_id);
	}
	
	
} 
