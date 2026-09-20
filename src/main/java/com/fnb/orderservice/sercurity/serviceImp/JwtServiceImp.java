package com.fnb.orderservice.sercurity.serviceImp;

import com.fnb.orderservice.sercurity.JwtService;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

public class JwtServiceImp implements JwtService {

    @Value("${jwt.secret}")
    String jwtSecret;

    @Override
    public String extractRole(String token) {
        return getClaims(token).get("ROLE", String.class);
    }
        

    @Override
    public boolean validateToken(String token, String email) {
        try {
           
            return getClaims(token).getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String extractEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                jwtSecret.getBytes(StandardCharsets.UTF_8)
        );
    }
    public Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
