package com.matheusfelixr.jwtapi.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.matheusfelixr.jwtapi.model.domain.User;
import com.matheusfelixr.jwtapi.security.JwtTokenUtil;
import com.matheusfelixr.jwtapi.service.UserService;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private UserDetailsService apiUserService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserService userService;
	
	@Bean
    public Docket api() { 
		
		List<SecurityScheme> schemeList = new ArrayList<>();
        schemeList.add(new ApiKey("Bearer", "Authorization", "header"));
		
        return new Docket(DocumentationType.SWAGGER_2)
			.produces(Collections.singleton("application/json"))
		    .consumes(Collections.singleton("application/json"))
		    .ignoredParameterTypes(Authentication.class)
		    .globalOperationParameters(
		    		Arrays.asList(
                    new ParameterBuilder()
                            .name("Authorization")
                            .modelRef(new ModelRef("string"))
                            .parameterType("header")
                            .required(true)
                            .hidden(true)
                            .defaultValue("Bearer " + security())
                            .build()
                    ))
		    .select()                                  
		    .apis(RequestHandlerSelectors.any())              
		    .paths(PathSelectors.any())                          
		    .build();                                           
    }
	
	public String security() {
		String token;
		try {
		createFristUser();
			UserDetails userDetails = this.apiUserService.loadUserByUsername("admin");
			token = jwtTokenUtil.generateToken(userDetails);
		} catch (Exception e) {
			e.printStackTrace();
			token = "";
		}

		return  token;
	}

	private void createFristUser() {
		User user = userService.findUserByUsername("admin");
		if(user == null) {
			user = new User();
			
			user.setUsername("admin");
			user.setPassword("123456");
			
			userService.createFirstUser(user);
		}
	}
}
