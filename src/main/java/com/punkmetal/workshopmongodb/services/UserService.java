package com.punkmetal.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punkmetal.workshopmongodb.domain.User;
import com.punkmetal.workshopmongodb.repository.UserRepository;
import com.punkmetal.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	//Injeção de depedência automatica
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
}
