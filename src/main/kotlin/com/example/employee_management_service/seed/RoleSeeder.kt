package com.example.employee_management_service.seed

import com.example.employee_management_service.constants.RoleConstants
import com.example.employee_management_service.domain.Role
import com.example.employee_management_service.repository.RoleRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class RoleSeeder(private val roleRepository: RoleRepository) : CommandLineRunner {

    val roles = listOf(RoleConstants.ADMIN, RoleConstants.EMPLOYEE)


    override fun run(vararg args: String) {
        roles.forEach { rolename ->
            if (!roleRepository.existsByName(rolename)) {
                val role = Role(name = rolename)
                roleRepository.save(role)
            }
        }
    }
  }







