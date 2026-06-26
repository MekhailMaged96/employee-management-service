package com.example.employee_management_service.mapper

import com.example.employee_management_service.domain.Employee
import com.example.employee_management_service.dto.EmployeeDto

fun Employee.toDto() = EmployeeDto(
    id = this.id,
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.user?.email ?: "",
    hireDate = this.hireDate,
    departmentId = this.department.id!!,
    departmentName = this.department.name
)

fun List<Employee>.toDtoList() = map { it.toDto() }
