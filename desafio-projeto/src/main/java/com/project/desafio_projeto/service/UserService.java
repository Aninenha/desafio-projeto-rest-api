package com.project.desafio_projeto.service;

import com.project.desafio_projeto.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserService {
	User findById(long id);
	User create(User userToCreate);

	@Repository
	public interface UserRepository extends JpaRepository<User, Long> {
		boolean existsByAccountNumber(String accountNumber);

	}
}
