package service;


import model.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    private static final String SECRET = "chave-secreta";
    private static final long EXPIRATION = 86400000;

    public String gerarToken(Usuario user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}