package com.example.employee_management_service.mapper

import com.example.employee_management_service.domain.Department
import com.example.employee_management_service.dto.DepartmentDto

fun Department.toDto() = DepartmentDto(
    id = this.id,
    name = this.name,
    description = this.description
)
fun DepartmentDto.toEntity() = Department(
    id = this.id,
    name = this.name,
    description = this.description
)


fun List<Department>.toDtoList() = map { it.toDto() }
