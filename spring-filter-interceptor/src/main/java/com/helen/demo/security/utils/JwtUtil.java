package com.helen.demo.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Generate a secure key for HS256
    private final String secretKey = "b}gB9hTa_c*QSx2^DFR%?t\"3A!'dn)UKy=`>8P&zCL.N:eX46kgQ\"ns>f4$?TW93d.'jyAxpD8R5X^Cv,Ph){eY#*Vk=u+6-Em@}Gv>r,g8L:p<Uf[Pu-z{Vw*BR_j4)YW/5T'yaeD=3+NX9\"6@Z$KLQ<WU'3j&ry%Mk85\"tqbCpxdu2=>#7meXn?Kw4$;TN~R@c!E`.YB\".J>N#shr/(;,T[!Uq{*&532~$E@<SpWu%VZKxA6:c?n=ejR"; // Change this to a secure secret key

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)// Use the secure key here
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes())) // Use the secure key here
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}



