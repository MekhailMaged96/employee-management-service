package com.example.employee_management_service.service

import com.example.employee_management_service.dto.LoginDto

interface AuthService {
    fun login(request: LoginDto): String
}
