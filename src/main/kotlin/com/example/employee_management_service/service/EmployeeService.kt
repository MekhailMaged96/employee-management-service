package com.example.employee_management_service.service

import com.example.employee_management_service.domain.Employee
import com.example.employee_management_service.dto.CreateEmployeeDto

interface EmployeeService {

    fun createEmployee(employeeDto: CreateEmployeeDto): Employee

    fun getEmployeeById(id: Long): Employee?

    fun getAllEmployees(): List<Employee>

    fun deleteEmployee(id: Long)
}