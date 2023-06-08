package br.com.fiap.globalSolution.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import br.com.fiap.globalSolution.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
        throws ServletException, IOException{

        // pegar o token header
        var token = getToken(request);

        // se for valido, autenticar
        if (token != null){
            var usuario = tokenService.getValidateUser(token);
            Authentication auth = new UsernamePasswordAuthenticationToken(usuario.getUsername(), null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        //chamar o proximo
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization"); // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")){
            return null;
        }

        return header.replace("Bearer ", "");
    }
    
}
