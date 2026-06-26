package com.example.employee_management_service.service

import com.example.employee_management_service.domain.Department
import com.example.employee_management_service.dto.DepartmentDto

interface DepartmentService {

    fun createDepartment(departmentDto: DepartmentDto): DepartmentDto
    fun getDepartmentById(id: Long): DepartmentDto?
    fun getAllDepartments(): List<DepartmentDto>
}