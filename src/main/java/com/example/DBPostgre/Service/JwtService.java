package com.example.DBPostgre.Service;
import com.example.DBPostgre.Model.mVigilante;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.security.SignatureException;
import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {
    private final String secretKey = "kS5x8J6Dc0vCpVpKm8bHwS/2shEUIkr7fDZWr7svX0rLlvY8fVDW0XEWZCmi4NTCk8aOJrVddqA3QyYGqIgIlvQ==";

    public String generateToken(Optional<mVigilante> optionalVigilante) {
        mVigilante vigilante = optionalVigilante.orElseThrow(() -> new IllegalArgumentException("Vigilante no encontrado"));

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000); // 1 día

        return Jwts.builder()
                .setSubject(vigilante.getUsuario())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
    }
}

