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

import com.masai.model.Post;
import com.masai.service.PostService;

@RestController
@RequestMapping("/api")

public class DriverController {

	@Autowired
	private PostService pService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts(){
		List<Post> list= pService.getAllPosts();
		return new ResponseEntity<List<Post>>(list,HttpStatus.OK);
	}
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id){
		Post p= pService.getPostById(id);
		return new ResponseEntity<Post>(p,HttpStatus.OK);
	}
	@PostMapping("/posts")
	public ResponseEntity<Post> addPost(@Valid @RequestBody Post p){
		Post post= pService.addPost(p);
		return new ResponseEntity<Post>(p,HttpStatus.CREATED);
	}
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable("id") Integer id
										   ,@RequestBody Post p){
		Post post= pService.updatePost(id, p);
		return new ResponseEntity<Post>(p,HttpStatus.OK);
	}
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable("id") Integer id){
		String p=pService.deletePostById(id);
		return new ResponseEntity<String>(p,HttpStatus.OK);
	}
	
	

	
}
