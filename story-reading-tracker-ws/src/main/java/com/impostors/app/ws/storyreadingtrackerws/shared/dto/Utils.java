package com.impostors.app.ws.storyreadingtrackerws.shared.dto;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import com.impostors.app.ws.storyreadingtrackerws.security.SecurityConstants;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Utils {

	private final Random RANDOM= new SecureRandom();
	private final String ALPHABET="0123456789ABCDEFGHUJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final String NUMBERS="0123456789";
	private final int ITERATIONS=10000;
	private final int KEY_LENGTH = 256;
	
	public String generateUserId(int length)
	{
		return generateRandomString(length);
	}
	public String generateStoryId(int length)
	{
		return generateRandomString(length);
	}
	public String generateStoryUserId(int length)
	{
		return generateRandomString(length);
	}
	public String generateFeedbackId(int length)
	{
		return generateRandomString(length);
	}
	public String generateFaceExperienceId(int length)
	{
		return generateRandomString(length);
	}
	public String generateAvatarId(int length){
		return generateRandomString(length);
	}

	public String generateVerificationCode(int length){
		return generateRandomIntegers(length);
	}

	
	
	private String generateRandomString(int length)
	{
		StringBuilder returnValue=new StringBuilder(length);
		for(int i=0;i<length;i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(returnValue);
	}

	private String generateRandomIntegers(int length)
	{
		StringBuilder returnValue=new StringBuilder(length);
		for(int i=0;i<length;i++) {
			returnValue.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
		}
		return new String(returnValue);
	}
	
	
	public static boolean hasTokenExpired(String token) {
		Claims claims=Jwts.parser()
				.setSigningKey(SecurityConstants.getTokenSecret())
				.parseClaimsJws(token).getBody();
		Date tokenExpirationDate=claims.getExpiration();
		Date todayDate=new Date();
		
		return tokenExpirationDate.before(todayDate);
	}
	
	public String generateEmailVerificationToken(String userId) {
	    String token = Jwts.builder()
	            .setSubject(userId)
	            .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants. EXPIRATION_TIME))
	            .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
	            .compact();
	    return token;
	}
	
	
}
