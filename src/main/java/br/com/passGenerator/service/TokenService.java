package br.com.passGenerator.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import br.com.passGenerator.model.entity.Usuario;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.nio.charset.StandardCharsets;

@Service
public class TokenService {
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private static final SecretKey SECRET = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    private static final long EXPIRATION = 86400000;

    public String gerarToken(Usuario user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET)
                .compact();
    }

    public String validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}