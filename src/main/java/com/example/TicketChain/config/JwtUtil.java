package com.example.TicketChain.config;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    private static final String SECRET_KEY = "your-256-bit-secret-key-1234567890abcdef"; // Thay bằng khóa bí mật an
                                                                                         // toàn
    private static final long EXPIRATION_TIME = 86400000; // 1 ngày

    public static String generateToken(String address) {
        return Jwts.builder()
                .setSubject(address)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,
                        new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName()))
                .compact();
    }
}
