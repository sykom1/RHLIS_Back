package com.amu.project_back.models;

public class AuthenticationResponse {

	private final String jwt;
	
	private final Utilisateur user;

	public AuthenticationResponse(String jwt, Utilisateur user) {
		this.jwt = jwt;
		this.user = user;
	}

	public String getJwt() {
		return jwt;
	}
	
	public Utilisateur getUser() {
		return user;
	}
}
