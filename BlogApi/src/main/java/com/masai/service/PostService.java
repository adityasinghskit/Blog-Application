package com.masai.service;

import java.util.List;

import com.masai.exception.CommentAreadyExistException;
import com.masai.exception.NoCommentFoundException;
import com.masai.exception.NoPostFoundException;
import com.masai.exception.PostAreadyExistException;
import com.masai.model.Comment;
import com.masai.model.Post;

public interface PostService {
public List<Post> getAllPosts() throws NoPostFoundException;
public Post getPostById(Integer id) throws NoPostFoundException;
public Post addPost(Post p) throws PostAreadyExistException;
public Post updatePost(Integer id, Post p) throws NoPostFoundException;
public String deletePostById(Integer id) throws NoPostFoundException;
public List<Comment> getAllComments(Integer id);
public Comment getCommentById(Integer pid, Integer cid);
public Comment addComment(Integer pid, Comment c) throws CommentAreadyExistException;
public Comment updateComment(Integer pid, Integer cid, Comment c) throws NoCommentFoundException;
public String deleteCommentById(Integer pid, Integer cid);
}
