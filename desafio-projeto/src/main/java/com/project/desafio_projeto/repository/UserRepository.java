package com.project.desafio_projeto.repository;

import com.project.desafio_projeto.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {

}
