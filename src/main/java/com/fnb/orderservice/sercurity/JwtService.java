package com.fnb.orderservice.sercurity;

public interface JwtService {
    String extractRole(String token);
    boolean validateToken(String token, String email);
    String extractEmailFromToken(String token);
}
