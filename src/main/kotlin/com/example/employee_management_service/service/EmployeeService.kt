package com.example.employee_management_service.service

import com.example.employee_management_service.domain.Employee
import com.example.employee_management_service.dto.CreateEmployeeDto
import com.example.employee_management_service.dto.EmployeeDto

public interface EmployeeService {

    fun createEmployee(employeeDto: CreateEmployeeDto): Employee

    fun getEmployeeById(id: Long): EmployeeDto?

    fun getAllEmployees(): List<EmployeeDto>

    fun deleteEmployee(id: Long)
}