package com.project.desafio_projeto.controller;

import com.project.desafio_projeto.Model.User;
import com.project.desafio_projeto.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/{id}")
	public ResponseEntity<User> create(@RequestBody User user){
		var createdUser = userService.create(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(createdUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		var user = userService.findById(id);
		return ResponseEntity.ok(user);
	}

}
