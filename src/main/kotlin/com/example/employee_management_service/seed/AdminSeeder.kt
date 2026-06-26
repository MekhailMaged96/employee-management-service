package com.example.employee_management_service.seed

import com.example.employee_management_service.constants.RoleConstants
import com.example.employee_management_service.domain.User
import com.example.employee_management_service.repository.RoleRepository
import com.example.employee_management_service.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
@Order(2)
class AdminSeeder(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String) {
        if (userRepository.existsByUsername("admin")) return

        val adminRole = roleRepository.findByName(RoleConstants.ADMIN)
            ?: error("ADMIN role not found — ensure RoleSeeder runs first")


        val admin = User(
            username = "admin",
            email = "admin@example.com",
            password = passwordEncoder.encode("Admin@1234")?: "Admin@1234",
            roles = mutableSetOf(adminRole)
        )

        userRepository.save(admin)
    }
}
