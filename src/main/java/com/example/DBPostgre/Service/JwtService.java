package com.example.DBPostgre.Service;
import com.example.DBPostgre.Model.mVigilante;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
public class JwtService {
    private final String secretKey = "1010150315";

    public String generateToken(mVigilante vigilante) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000); // 1 día

        return Jwts.builder()
                .setSubject(vigilante.getUsuario())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
