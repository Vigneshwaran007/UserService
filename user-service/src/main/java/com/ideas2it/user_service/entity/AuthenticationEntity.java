package com.ideas2it.user_service.entity;

/**
 * AuthenticationEntity which represent entity for Authenticated data.
 * @author Vigneshwaran N
 */
public class AuthenticationEntity {
	String userName;
	String password;
	String token;
	
	
	public AuthenticationEntity() {
		super();
	}
	
	private AuthenticationEntity(AuthenticationEntityBuilder builder) {
		super();
		this.userName = builder.userName;
		this.password = builder.password;
		this.token = builder.token;
	}
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public String getToken() {
		return token;
	}

public static class AuthenticationEntityBuilder{
	String userName;
	String password;
	String token;
	
	public AuthenticationEntityBuilder userName(String userName) {
		this.userName=userName;
		return this;
	}
	
	public AuthenticationEntityBuilder password(String password) {
		this.password=password;
		return this;
	}
	
	public AuthenticationEntityBuilder token(String token) {
		this.token=token;
		return this;
	}
	
	public AuthenticationEntity build() {
		AuthenticationEntity entity=new AuthenticationEntity(this);
		return entity;
	}
}
}
