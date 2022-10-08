package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CommentAreadyExistException;
import com.masai.exception.NoCommentFoundException;
import com.masai.exception.NoPostFoundException;
import com.masai.exception.PostAreadyExistException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.repository.CommentDao;
import com.masai.repository.PostDao;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao pDao;
	@Autowired
	private CommentDao cDao;
	
	@Override
	public List<Post> getAllPosts() throws NoPostFoundException {
		List<Post> list= pDao.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new NoPostFoundException("No post found!");
		}
	}

	@Override
	public Post getPostById(Integer id) throws NoPostFoundException {
		Optional<Post> opt= pDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new NoPostFoundException("No post found by id: "+id);
		}
	}

	@Override
	public Post addPost(Post p) throws PostAreadyExistException {
		Optional<Post> opt= pDao.findById(p.getPostId());
		if(opt.isPresent()) {
			throw new PostAreadyExistException("Post alrady exists by id: "+p.getPostId());
		}
		else {
			return pDao.save(p);
		}
	}

	@Override
	public Post updatePost(Integer id, Post p) throws NoPostFoundException {
		Optional<Post> opt= pDao.findById(p.getPostId());
		if(opt.isPresent()) {
			return pDao.save(p);
		}
		else {
			throw new NoPostFoundException("No post exists by id: "+p.getPostId());
		}
	}

	@Override
	public String deletePostById(Integer id) throws NoPostFoundException {
		Optional<Post> opt= pDao.findById(id);
		if(opt.isPresent()) {
			pDao.deleteById(id);
			return "Post deleted by id: "+id;
		}
		else {
			throw new NoPostFoundException("No post exixts by id: "+id);
		}
		
	}

	

}
