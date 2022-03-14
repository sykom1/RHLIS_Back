package com.amu.project_back.models;

import javax.persistence.*;

@Entity
public class TokenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = 0;
	
	@Basic
	private String jwt;
	
	@OneToOne()
	private Utilisateur user;

	public TokenEntity() {
		
	}
	
	public TokenEntity(String jwt, Utilisateur user) {
		this.jwt = jwt;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	
	
	
}
