package com.example.employee_management_service.repository

import com.example.employee_management_service.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface EmployeeRepository  : JpaRepository<Employee, Long> {
    fun findByUserEmail(email: String): Employee?
    fun existsByUserEmail(email: String): Boolean
    fun findAllByDepartmentId(departmentId: Long): List<Employee>
}