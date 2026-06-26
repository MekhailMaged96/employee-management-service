package com.example.employee_management_service.dto

data class RegisterDto(
    val username: String,
    val email: String,
    val password: String,
    val role: String
)
