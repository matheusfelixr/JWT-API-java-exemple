package com.matheusfelixr.jwtapi.model.dto;

import lombok.Data;

@Data
public class AuthenticateRequestDto {
	
	private String username;
	private String password;
	
}
