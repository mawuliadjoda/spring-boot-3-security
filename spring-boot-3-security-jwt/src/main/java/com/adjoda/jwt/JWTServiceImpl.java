package com.adjoda.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private String generateToken(UserDetails userDetails){
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWTConstants.JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey()).build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignKey() {
        // return Keys.hmacShaKeyFor(Decoders.BASE64.decode("own-generate-key"));
        return key;
    }
}
