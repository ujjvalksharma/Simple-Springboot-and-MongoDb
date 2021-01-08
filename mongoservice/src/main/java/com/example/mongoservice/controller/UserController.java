package com.example.mongoservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoservice.model.User;
import com.example.mongoservice.repository.UserRepository;

@RequestMapping("/User")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
		
	}

	@GetMapping(value = "/findAll")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<User> getUser(@PathVariable(name = "id") int id) {
		return userRepository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "book deleted with id : " + id;
	}
	
}
