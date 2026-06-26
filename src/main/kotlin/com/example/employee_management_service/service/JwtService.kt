package com.example.employee_management_service.service

import com.example.employee_management_service.domain.UserPrincipal
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.Date
import javax.crypto.SecretKey

@Service
class JwtService {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration-ms}")
    private var expirationMs: Long = 86400000

    fun generateToken(userDetails: UserDetails): String {
        val roles = userDetails.authorities.map { it.authority }
        val email = (userDetails as? UserPrincipal)?.email

        return Jwts.builder()
            .subject(userDetails.username)
            .claim("email", email)
            .claim("roles", roles)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expirationMs))
            .signWith(signingKey())
            .compact()
    }

    fun extractUsername(token: String): String =
        extractClaims(token).subject

    fun extractRoles(token: String): List<String> {
        @Suppress("UNCHECKED_CAST")
        return extractClaims(token).get("roles", List::class.java) as List<String>
    }

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean =
        extractUsername(token) == userDetails.username && !isTokenExpired(token)

    private fun isTokenExpired(token: String): Boolean =
        extractClaims(token).expiration.before(Date())

    private fun extractClaims(token: String): Claims =
        Jwts.parser()
            .verifyWith(signingKey())
            .build()
            .parseSignedClaims(token)
            .payload

    private fun signingKey(): SecretKey =
        Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))
}
