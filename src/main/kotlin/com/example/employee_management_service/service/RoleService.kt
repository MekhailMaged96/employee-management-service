package com.example.employee_management_service.service

import com.example.employee_management_service.domain.Role

interface RoleService {

    fun getRoleById(id: Long): Role?

    fun  getAllRoles(): List<Role>

}