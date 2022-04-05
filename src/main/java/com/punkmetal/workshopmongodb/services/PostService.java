package com.punkmetal.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punkmetal.workshopmongodb.domain.Post;
import com.punkmetal.workshopmongodb.repository.PostRepository;
import com.punkmetal.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	//Injeção de depedência automatica
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado!"));
	}
	
	public List<Post> findByTitle(String title) {
		return repository.findByTitleContainingIgnoreCase(title);
	}
}
