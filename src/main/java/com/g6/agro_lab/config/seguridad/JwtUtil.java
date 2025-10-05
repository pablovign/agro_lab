package com.g6.agro_lab.config.seguridad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {
    private final String CLAVE_SECRETA = "psvsb44";

    public String generarToken(UserDetails userDetails){
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("roles", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256(CLAVE_SECRETA));
    }

    public String extractUsername(String token) {
        return JWT.require(Algorithm.HMAC256(CLAVE_SECRETA)).build().verify(token).getSubject();
    }

    public List<String> extractRoles(String token) {
        return JWT.require(Algorithm.HMAC256(CLAVE_SECRETA)).build().verify(token)
                .getClaim("roles").asList(String.class);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername());
    }
}
