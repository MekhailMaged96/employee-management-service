package com.example.employee_management_service.dto

import java.time.LocalDate

data class EmployeeDto(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val hireDate: LocalDate,
    val departmentId: Long,
    val departmentName: String?
)
