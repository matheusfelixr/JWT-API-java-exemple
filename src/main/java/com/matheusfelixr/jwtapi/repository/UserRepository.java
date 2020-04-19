package com.matheusfelixr.jwtapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusfelixr.jwtapi.model.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByusername(String userName);
}
