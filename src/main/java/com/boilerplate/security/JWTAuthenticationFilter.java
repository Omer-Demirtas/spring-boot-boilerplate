package com.boilerplate.security;

import com.boilerplate.security.service.CustomUserDetailsService;
import com.boilerplate.security.service.JWTTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter
{
    @Autowired
    private JWTTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = extractTokenFromRequest(request);
            if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token))
            {
                Long id = jwtTokenProvider.getUserIdFromJWT(token);
                UserDetails user = userDetailsService.loadUserById(id);
                if (user != null)
                {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
        catch (Exception e) {return;}
    }

    private String extractTokenFromRequest(HttpServletRequest request)
    {
        String bearer = request.getHeader("authorization");
        if(StringUtils.hasText(bearer) && bearer.startsWith("bearer ")) return bearer.substring("Bearer".length() + 1);
        return null;
    }
}
