package com.matheusfelixr.jwtapi.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TAB_USER" )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	
	public User() {
		super();
	}
	public String[] getRoles() {
		return new String[]{"USER"};
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username) {
		this(username,null);
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equalsIgnoreCase(other.username))
			return false;
		return true;
	}
}
