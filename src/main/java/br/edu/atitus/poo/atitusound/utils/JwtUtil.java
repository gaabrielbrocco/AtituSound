package br.edu.atitus.poo.atitusound.utils;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class JwtUtil {
	
	private final static String jwtSecret = "===================AtitusSecretJWT====================";
	private final static int jwtExpirationMs = 86400000;
	private static Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	public static String generateTokenFromUsername(String username) throws InvalidKeyException {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(key(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public static String getJwtFromRequest(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization");
		if (jwt != null && !jwt.isEmpty()) {
			return jwt.substring(7);
		}
		return null;
	}
	
	public static boolean validaJwtToken(String jwt) {
		try {
			Jwts.parserBuilder().setSigningKey(key()).build().parse(jwt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
		public static String getUserNameFromJwtToken(String token) {
			return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject();
		}
	}
