package com.example.employee_management_service.dto

import java.time.LocalDate

data class CreateEmployeeDto(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String,
    val departmentId: Long,
    val hireDate: LocalDate
)
