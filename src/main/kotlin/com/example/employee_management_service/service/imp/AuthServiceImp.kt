package com.example.employee_management_service.service.imp

import com.example.employee_management_service.dto.LoginDto
import com.example.employee_management_service.service.AuthService
import com.example.employee_management_service.service.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthServiceImp(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService
) : AuthService {

    override fun login(request: LoginDto): String {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.username, request.password)
        )

        val userDetails = userDetailsService.loadUserByUsername(request.username)
        return jwtService.generateToken(userDetails)
    }
}
