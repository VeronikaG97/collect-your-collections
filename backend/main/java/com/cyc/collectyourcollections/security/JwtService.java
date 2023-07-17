package com.cyc.collectyourcollections.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY ="8qknkvui443PgsvJ/WvAEuHLe1RruTZDWbnf12VnTF2YD/UJo9bova6x83YP/0hlia5lwV8B7IiuprAaor7BCwBzTGYSrjKiJShJo+gsIuFmudNhZhomUFgwClVdGHdy9h+2O5OEoq6BrEJ420nIiy5DmTpqqQ6j3gr/MyXA+SEgEWBD2eSNGS8qQfxNFY2mm7hVQmEFUL6zWm3oCQ5aQMIJj+hbouWAoyQnhrzknUVq+JwMJRP6DRB7KzUzOGVIHaO5AZC+ZqMwuOhw5Ri3VqxGYg1w0xvZnNbGSv12U9RTwtTn4F5j20vMw+pGeRSF8o88eumow7Nqfnv5ef3GFFJkQlJvUNOw1GZdbKfvLZg=";
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ){
        int plusTimeThatTokenIsValid = 1000 * 60 + 24;
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + plusTimeThatTokenIsValid))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
