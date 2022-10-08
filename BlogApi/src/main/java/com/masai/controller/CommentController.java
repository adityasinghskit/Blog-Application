package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Comment;
import com.masai.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
@Autowired
private CommentService cService;

@GetMapping("/posts/{pid}/comments")
public ResponseEntity<List<Comment>> getAllComments(@PathVariable("pid") Integer pid){
	List<Comment> list= cService.getAllComments(pid);
	return new ResponseEntity<List<Comment>>(list,HttpStatus.ACCEPTED);
}
@GetMapping("/posts/{pid}/comments/{cid}")
public ResponseEntity<Comment> getCommentById(@PathVariable("pid") Integer pid,
											  @PathVariable("cid") Integer cid){
	Comment c= cService.getCommentById(pid, cid);
	return new ResponseEntity<Comment>(c,HttpStatus.ACCEPTED);
}
@PostMapping("/posts/{pid}/comments")
public ResponseEntity<Comment> addComment(@PathVariable("pid") Integer pid,
										  @Valid @RequestBody Comment c){
	Comment c1= cService.addComment(pid,c);
	return new ResponseEntity<Comment>(c1,HttpStatus.ACCEPTED);
}
@PutMapping("/posts/{pid}/comments/{cid}")
public ResponseEntity<Comment> updateComment(@PathVariable("pid") Integer pid,
											  @PathVariable("cid") Integer cid,
											  @Valid @RequestBody Comment c){
	Comment c1= cService.updateComment(pid,cid,c);
	return new ResponseEntity<Comment>(c1,HttpStatus.ACCEPTED);
}
@DeleteMapping("/posts/{pid}/comments/{cid}")
public ResponseEntity<String> deleteCommentById(@PathVariable("pid") Integer pid,
											  @PathVariable("cid") Integer cid){
	String s= cService.deleteCommentById(pid, cid);
	return new ResponseEntity<String>(s,HttpStatus.ACCEPTED);
}
}
