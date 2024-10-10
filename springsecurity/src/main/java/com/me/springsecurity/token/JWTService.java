package com.me.springsecurity.token;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Service
public class JWTService {
    private static final String secret = "202EEFA9C5F5C565801E21D33D4C2D91F37125322D93B673422767AEDD8C0FE0D145F6D0197A15BA7DC3534ED018999A8FBF1C1AE1F4BC8395FA2F659BDDDCEE";
    private static final long validateTime = TimeUnit.MINUTES.toMillis(30);
    public String generateToken(UserDetails userDetails) {
        Map<String, String> moreData = new HashMap<>();
        moreData.put("link", "lmaowibu.com");
        return Jwts.builder()
                .claims(moreData)
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(validateTime)))
                .signWith(generateKey())
                .compact();
    }
    private SecretKey generateKey() {
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(decodedKey);
    }
    public String extractUsername(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    private Claims getClaims(String jwt) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    public boolean isTokenValid(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }
}
