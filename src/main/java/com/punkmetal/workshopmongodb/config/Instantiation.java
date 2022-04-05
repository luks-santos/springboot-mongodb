package com.punkmetal.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.punkmetal.workshopmongodb.domain.Post;
import com.punkmetal.workshopmongodb.domain.User;
import com.punkmetal.workshopmongodb.dto.AuthorDTO;
import com.punkmetal.workshopmongodb.dto.CommentDTO;
import com.punkmetal.workshopmongodb.repository.PostRepository;
import com.punkmetal.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User joao = new User(null, "Joao Escobar", "escobar@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, joao));
		
		Post post1 = new Post(null, sdf.parse("04/04/2022"), "Partiu codar", "Codando o dia todo!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("04/04/2022"), "Bora dormir", "Dormindo!", new AuthorDTO(maria));
		
		CommentDTO com1 = new CommentDTO("Bons estudos!", sdf.parse("04/04/2022"), new AuthorDTO(bob));
		CommentDTO com2 = new CommentDTO("É isso", sdf.parse("04/04/2022"), new AuthorDTO(alex));
		CommentDTO com3 = new CommentDTO("Boa noite", sdf.parse("04/04/2022"), new AuthorDTO(joao));
		
		post1.getComments().addAll(Arrays.asList(com1, com2));
		post2.getComments().add(com3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
