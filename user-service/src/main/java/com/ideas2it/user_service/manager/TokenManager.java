package com.ideas2it.user_service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ideas2it.user_service.entity.AuthenticationEntity;
import com.ideas2it.user_service.util.JwtUtil;

/**
 * TokenManager is used to manage token for authentication.
 * 
 * @author Vigneshwaran N
 */
@Service
public class TokenManager {

	@Autowired
	public TokenManager(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	public AuthenticationEntity generateToken(@RequestBody AuthenticationEntity authenticateEntity) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateEntity.getUserName(),
					authenticateEntity.getPassword()));
		} catch (Exception exception) {
			throw new Exception("inavalid username/password");
		}
		String token = jwtUtil.generateToken(authenticateEntity.getUserName());
		AuthenticationEntity authenticationEntityReturn = new AuthenticationEntity.AuthenticationEntityBuilder()
				.token(token).build();
		return authenticationEntityReturn;
	}
}
