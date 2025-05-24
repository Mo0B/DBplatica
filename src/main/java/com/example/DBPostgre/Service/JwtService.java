package com.example.DBPostgre.Service;
import com.example.DBPostgre.Model.mVigilante;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtService {
    private final String secretKey = "kS5x8J6Dc0vCpVpKm8bHwS/2shEUIkr7fDZWr7svX0rLlvY8fVDW0XEWZCmi4NTCk8aOJrVddqA3QyYGqIgIlvQ==";

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
