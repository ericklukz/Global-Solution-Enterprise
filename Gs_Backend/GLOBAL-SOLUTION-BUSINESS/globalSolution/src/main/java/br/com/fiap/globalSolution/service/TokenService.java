package br.com.fiap.globalSolution.service;

import java.time.temporal.ChronoUnit;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.JWT;
import br.com.fiap.globalSolution.models.Credencial;
import br.com.fiap.globalSolution.models.Token;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.UsuarioRepository;

@Service
public class TokenService {

    @Autowired
    UsuarioRepository repository;

    @Value("${jwt.secret}")
    String secret;
    
    public Token generateToken(@Valid Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256(secret);
        String token = JWT.create()
                    .withSubject(credencial.username())
                    .withIssuer("Planteq")
                    .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                    .sign(alg)
                    ;
        return new Token(token, "JWT", "Bearer");
    }

    public Usuario getValidateUser (String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var username = JWT.require(alg)
                        .withIssuer("Planteq")
                        .build()
                        .verify(token)
                        .getSubject();

        return repository.findByUsername(username)
            .orElseThrow(() -> new JWTVerificationException("Usuario invalido"));
    }
}
