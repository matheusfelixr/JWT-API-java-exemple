package com.matheusfelixr.jwtapi.model.dto;

import com.matheusfelixr.jwtapi.model.domain.User;

import lombok.Data;

@Data
public class AuthenticateResponseDto {
	
	private String token;
	private User user;
	
	public AuthenticateResponseDto(String token, User user) {
		this.token = token;
		this.user = user;
	}
}
