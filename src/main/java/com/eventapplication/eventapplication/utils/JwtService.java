package com.eventapplication.eventapplication.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.access.AccessDeniedException;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

public class JwtService {

    private static final String SECRET_KEY ="9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";
    private JwtService() {
    }


    public static String generateToken(UUID id) {
        return Jwts
                .builder()
                .setSubject(id.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 60 ))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private static Key getSigningKey() {
        final var keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public static Claims extractUsername(String token) {
        try{
            return extractClaims(token);
        }catch(ExpiredJwtException e) {
            throw new AccessDeniedException("Access denied");
        }catch (Exception ex) {
            throw new AccessDeniedException("Invalid token");
        }
    }

    public static boolean isTokenValid(
            String token
    ) {
        final Claims username = extractUsername(token);
        return  !isTokenExpired(username);
    }

    private static boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

    private static Claims extractClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
