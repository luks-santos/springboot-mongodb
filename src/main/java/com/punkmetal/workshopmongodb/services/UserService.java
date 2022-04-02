package com.punkmetal.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punkmetal.workshopmongodb.domain.User;
import com.punkmetal.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
	//Injeção de depedência automatica
	@Autowired
	private UserRepository reposiry;
	
	public List<User> findAll() {
		return reposiry.findAll();
	}
}
