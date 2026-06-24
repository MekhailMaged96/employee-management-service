package com.example.employee_management_service.service.imp

import com.example.employee_management_service.domain.Role
import com.example.employee_management_service.repository.RoleRepository
import com.example.employee_management_service.service.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImp (private  val roleRepository: RoleRepository) : RoleService{

    override fun getRoleById(id: Long): Role? {
        return  roleRepository.findById(id).orElse(null)
    }

    override fun getAllRoles(): List<Role> {
        return roleRepository.findAll()
    }
}