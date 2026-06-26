package com.example.employee_management_service.service

import com.example.employee_management_service.domain.Role
import com.example.employee_management_service.dto.RoleDto

interface RoleService {

    fun getRoleById(id: Long): RoleDto?

    fun getAllRoles(): List<RoleDto>

    fun getRoleByName(name: String): RoleDto?
}