package com.example.TicketChain.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import com.example.TicketChain.core.Role;

import java.util.Date;

public class JwtUtil {
    // Bí mật phải đủ độ dài (ít nhất 256 bit = 32 ký tự ASCII)
    private static final String SECRET = "988e753f868635b2839f912944216875fa0ff1a0e288c533d426ae20cc23cb88c0b767a500555d8334d5b9a246eab56491f710ae96c2806ffd8a853295c08235";
    private static final long EXPIRATION_TIME = 86400000; // 1 ngày
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String address, Role role) {
        return Jwts.builder()
                .setSubject(address)
                .claim("role", role.name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String validateTokenAndGetSubject(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static Claims decodeToken(String token) throws JwtException {
        // Parse và validate token
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Khóa bí mật dùng để xác thực chữ ký
                .build()
                .parseClaimsJws(token) // Parse token JWT
                .getBody(); // Lấy phần payload (claims)
    }
}
