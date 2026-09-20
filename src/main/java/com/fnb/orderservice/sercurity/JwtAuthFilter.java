package com.fnb.orderservice.sercurity;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@Component 
public class JwtAuthFilter extends OncePerRequestFilter{
    private final String HEADER_AUTHORIZATION = "Authorization";
    private final String BEARER_PREFIX = "Bearer ";

    private final JwtService jwtService;
    private final UserDetailsService userDetailsSer;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader(HEADER_AUTHORIZATION);

        //if
        if(authHeader == null || !authHeader.startsWith(BEARER_PREFIX)){
            filterChain.doFilter(request, response);
            return; 
        }
        String token = authHeader.substring(BEARER_PREFIX.length());

        try {
            String username = jwtService.extractEmailFromToken(token);

            if (username == null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsSer.loadUserByUsername(username);
                if (jwtService.validateToken(token, username)) {
                    UsernamePasswordAuthenticationToken Usertoken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(Usertoken);
                }
            }

        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }
    }

}
