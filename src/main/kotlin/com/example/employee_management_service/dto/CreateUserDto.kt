package com.example.employee_management_service.dto

data class CreateUserDto(
    val username: String,
    val email: String,
    val password: String
)
