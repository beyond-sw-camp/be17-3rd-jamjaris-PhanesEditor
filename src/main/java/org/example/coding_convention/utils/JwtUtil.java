package org.example.coding_convention.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET = "abcdeffghijklmnopqrstuvwxyz0123456";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    private static final Long EXP = 1000 * 60 * 240L;

    public static String generateToken(String email, Integer idx, String nickname) {

        Map<String, String> claims = new HashMap<>();
        claims.put("idx", "" + idx);
        claims.put("email", email);
        claims.put("nickname", nickname);
        claims.put("role", "USER");

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXP))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static void deleteToken(HttpServletResponse response) {

        Cookie cookie = new Cookie("SJB_AT", null); // 토큰값 제거
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 만료 즉시
        response.addCookie(cookie);


    }


    public static String getValue(Claims claims, String key) {
        String value = (String) claims.get(key);

        return value;
    }

    public static Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

