package com.ideas2it.user_service.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JwtUtil class used to generate customize Jwt token.
 * 
 * @author Vigneshwaran N
 */
@Service
public class JwtUtil {

	@Value("${secretkey}")
	private String secret;

	private static final Logger logger = LogManager.getLogger(JwtUtil.class);

	/**
	 * extractUsername used to extract username from token.
	 * 
	 * @param token
	 * @author Vigneshwaran N
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * extractExpiration used to extract expiration detail from token.
	 * 
	 * @param token
	 * @author Vigneshwaran N
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	/**
	 * extractClaim used to extract claim detail from token.
	 * 
	 * @param token
	 * @param claimsResolver
	 * @author Vigneshwaran N
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * extractAllClaims used to extract all claim details from token.
	 * 
	 * @param token
	 * @author Vigneshwaran N
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * isTokenExpired used to check token expired or not.
	 * 
	 * @param token
	 * @author Vigneshwaran N
	 */
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	/**
	 * generateToken used to generate token from user name.
	 * 
	 * @param username
	 * @author Vigneshwaran N
	 */
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	/**
	 * createToken used to create new token.
	 * 
	 * @param claims
	 * @param subject
	 * @author Vigneshwaran N
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		logger.log(Level.ALL, "secret++++++++++" + secret);
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	/**
	 * validateToken used to validate token.
	 * 
	 * @param token
	 * @param userDetails
	 * @author Vigneshwaran N
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		logger.log(Level.ALL, "extractUsername(token)" + extractUsername(token));
		return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
