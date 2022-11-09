package com.boilerplate.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@Component
public class JWTTokenProvider
{
    @Value("${app.secret.key}")
    private String SECRET_KEY;

    @Value("${app.expires.time}")
    private Long EXPIRES_TIME;

    public String generateJWTToken(Authentication authentication)
    {
        JWTUserDetails jwtUserDetails = (JWTUserDetails) authentication.getPrincipal();
        Date expireDate = new Date(new Date().getTime() + this.EXPIRES_TIME);
        return Jwts.builder()
                .setSubject(jwtUserDetails.getId().toString())
                .setExpiration(expireDate).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.ES512, SECRET_KEY).compact();
    }

    public Long getUserIdFromJWT(String token)
    {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

    public Boolean validateToken(String token)
    {
        try
        {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (Exception ex) {return false;}
    }

    public Boolean isTokenExpired(String token)
    {
        Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}
