package com.project.desafio_projeto.service.impl;

import com.project.desafio_projeto.Model.User;
import com.project.desafio_projeto.repository.UserRepository;
import com.project.desafio_projeto.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User create(User userToCreate) {
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("Account Number already exists");
		}
		return userRepository.save(userToCreate);
	}
	@Override
	public User findById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
	}

}
