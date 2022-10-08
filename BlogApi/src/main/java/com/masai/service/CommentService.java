package com.masai.service;

import java.util.List;

import com.masai.exception.CommentAreadyExistException;
import com.masai.exception.NoCommentFoundException;
import com.masai.model.Comment;

public interface CommentService {
	public List<Comment> getAllComments(Integer id);
	public Comment getCommentById(Integer pid, Integer cid);
	public Comment addComment(Integer pid, Comment c) throws CommentAreadyExistException;
	public Comment updateComment(Integer pid, Integer cid, Comment c) throws NoCommentFoundException;
	public String deleteCommentById(Integer pid, Integer cid);
}
