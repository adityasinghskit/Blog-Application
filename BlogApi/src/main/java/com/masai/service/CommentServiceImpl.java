package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CommentAreadyExistException;
import com.masai.exception.NoCommentFoundException;
import com.masai.exception.NoPostFoundException;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.repository.CommentDao;
import com.masai.repository.PostDao;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private PostDao pDao;
	@Autowired
	private CommentDao cDao;
	@Autowired
	private PostService pService;
	
	@Override
	public List<Comment> getAllComments(Integer pid) {
		
		Post p= pService.getPostById(pid);
		
			List<Comment> list= p.getComments();
			if(list.size()>0) {
				return list;
			}
			else {
				throw new NoCommentFoundException("No comment found!");
			}
	}

	@Override
	public Comment getCommentById(Integer pid, Integer cid){
		Post p= pService.getPostById(pid);
		/*Optional<Comment> opt= cDao.findById(cid);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new NoCommentFoundException("No comment exists by id: "+cid);
		}*/
		List<Comment> list= getAllComments(pid);
		for(Comment c: list) {
			if(c.getCommentId()==cid) {
				return c;
			}
		}
		throw new NoCommentFoundException("No comment exists by id: "+cid);
		
		
	}

	@Override
	public Comment addComment(Integer pid, Comment c) throws CommentAreadyExistException {
		Post p= pService.getPostById(pid);
		List<Comment> list= p.getComments();
		for(Comment i: list) {
			if(i.getCommentId()==c.getCommentId()) {
				throw new CommentAreadyExistException("A comment already exists by id: "+c.getCommentId());
			}
		}
		list.add(c);
		//pService.updatePost(pid, p);
		pDao.save(p);
		return c;
		
		/*Optional<Comment> opt= cDao.findById(c.getCommentId());
		
		if(opt.isPresent()) {
			
			throw new CommentAreadyExistException("A comment already exists by id: "+c.getCommentId());
		}
		else {
			return cDao.save(c);
		}*/
	}

	@Override
	public Comment updateComment(Integer pid, Integer cid, Comment c) throws NoCommentFoundException {
		Post p= pService.getPostById(pid);
		/*Optional<Comment> opt= cDao.findById(cid);
		if(opt.isPresent()) {
			return cDao.save(c);
		}
		else {
			throw new NoCommentFoundException("No comment exists by id: "+cid);
		}*/
		
		List<Comment> list= p.getComments();
		for(Comment i: list) {
			if(i.getCommentId()==cid) {
				return cDao.save(c);
			}
		}
		throw new NoCommentFoundException("No comment exixts by id: "+cid);
		
	}

	@Override
	public String deleteCommentById(Integer pid, Integer cid) throws NoCommentFoundException {
		Post p= pService.getPostById(pid);
		Optional<Comment> opt= cDao.findById(cid);
		if(opt.isPresent()) {
			cDao.deleteById(cid);
			return "Comment deleted by id: "+cid;
		}
		else {
			throw new NoCommentFoundException("No comment exists by id: "+cid);
		}
	}
}
