package com.academia.academia.config;

import com.academia.academia.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Filtern extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = buscarToken(request);
        if (token != null){
            String usuarioLogin = tokenService.buscarUsuarioToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private String buscarToken(HttpServletRequest request){
        var authorization = request.getHeader("Authorization");
        if (authorization == null){
            return authorization.replace("Bearer ", "");
        }
        return null;
    }
}
