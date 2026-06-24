package com.example.employee_management_service.repository

import com.example.employee_management_service.domain.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository  : JpaRepository<Role, Long> {
    fun findByName(name: String): Role?
}