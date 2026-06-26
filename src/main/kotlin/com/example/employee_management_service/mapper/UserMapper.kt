package com.example.employee_management_service.mapper

import com.example.employee_management_service.domain.User
import com.example.employee_management_service.dto.CreateUserDto

fun CreateUserDto.toEntity() = User(
    username = this.username,
    email = this.email,
    password = this.password
)
