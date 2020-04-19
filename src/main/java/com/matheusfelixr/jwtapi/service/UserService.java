package com.matheusfelixr.jwtapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.matheusfelixr.jwtapi.model.domain.User;
import com.matheusfelixr.jwtapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
			
	@Autowired 
	private UserRepository userRepository;
	
	
    public User create(User user) {
    	user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    	
		return userRepository.save(user);
    }
    
    public User createFirstUser(User user) {
    	
    	user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    	
		return userRepository.save(user);
    }
	
    public User findUserByUsername(String username) {
    	
    	User ret = userRepository.findByusername(username);
    	
    	
    	
		return ret;
    }
}