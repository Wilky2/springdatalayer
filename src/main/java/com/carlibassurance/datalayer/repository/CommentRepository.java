package com.carlibassurance.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlibassurance.datalayer.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
