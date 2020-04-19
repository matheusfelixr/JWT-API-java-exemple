package com.matheusfelixr.jwtapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/unauthenticated-route")
public class UnauthenticatedRouteController {
	
	@GetMapping
	public String getMessage() {
		return "Esta eh uma rota nao autenticada, nao havendo a necessidade de estar autenticado para buscar este recurso";
	}

}
