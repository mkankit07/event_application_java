package com.eventapplication.eventapplication.configuration.jwt;

import com.eventapplication.eventapplication.common.ResponseBuilder;
import com.eventapplication.eventapplication.services.UserDetailsServiceImpl;
import com.eventapplication.eventapplication.utils.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsServiceImpl userDetailsService;
    private final ObjectMapper objectMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        try{
            Claims claims = JwtService.extractUsername(header.substring(7));
            if(claims!=null && JwtService.isTokenValid(header.substring(7))){
                String username = claims.getSubject();
                Authentication authentication = new UsernamePasswordAuthenticationToken(username,"",new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }catch (Exception e){
            ResponseBuilder errorResponse = new ResponseBuilder().setMassage(e.getMessage()).setStatus(HttpStatus.UNAUTHORIZED.value()).build();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(toJson(errorResponse));
        }


    }
    private String toJson(ResponseBuilder response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
         List<String> allowedUrl= Arrays.asList("/doc",
                 "/swagger*/**",
                 "/v3/api-docs/**",
                 "/v1/api/auth/login",
                 "/v1/api/auth/register");
        return allowedUrl.contains(request.getRequestURI());

    }
}
