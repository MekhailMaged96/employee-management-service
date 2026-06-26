package com.example.employee_management_service.service.imp

import com.example.employee_management_service.domain.Role
import com.example.employee_management_service.dto.RoleDto
import com.example.employee_management_service.dto.toDto
import com.example.employee_management_service.repository.RoleRepository
import com.example.employee_management_service.service.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImp (private  val roleRepository: RoleRepository) : RoleService{

    override fun getRoleById(id: Long): RoleDto? {
        return roleRepository.findById(id).orElse(null)?.toDto()
    }

    override fun getAllRoles(): List<RoleDto> {
        return roleRepository.findAll().map { it.toDto() }
    }

    override fun getRoleByName(name: String): RoleDto? {
        return roleRepository.findByName(name)?.toDto()
    }
}