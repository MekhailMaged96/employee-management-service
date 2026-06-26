package com.example.employee_management_service.service.imp

import com.example.employee_management_service.constants.RoleConstants
import com.example.employee_management_service.domain.Employee
import com.example.employee_management_service.dto.CreateEmployeeDto
import com.example.employee_management_service.dto.CreateUserDto
import com.example.employee_management_service.dto.EmployeeDto
import com.example.employee_management_service.dto.toEntity
import com.example.employee_management_service.exception.ResourceNotFoundException
import com.example.employee_management_service.mapper.toDto
import com.example.employee_management_service.mapper.toDtoList
import com.example.employee_management_service.mapper.toEntity
import com.example.employee_management_service.repository.*
import com.example.employee_management_service.service.EmployeeService
import com.example.employee_management_service.service.RoleService
import com.example.employee_management_service.service.UserService
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImp(
    private val employeeRepository: EmployeeRepository,
    private val userService: UserService,
    private val roleService: RoleService,
    private val departmentRepository: DepartmentRepository
) : EmployeeService {

    override fun createEmployee(employeeDto: CreateEmployeeDto): Employee {
        val department = departmentRepository.findById(employeeDto.departmentId)
            .orElseThrow { RuntimeException("Department not found") }

        val existingUser = userService.getUserByEmail(employeeDto.email)
        if (existingUser != null) {
            throw BadRequestException("User with email ${employeeDto.email} already exists")
        }

        val newUser = userService.createUser(
            CreateUserDto(
                username = employeeDto.username,
                email = employeeDto.email,
                password = employeeDto.password
            ).toEntity())


        val employeeRole = roleService.getRoleByName(RoleConstants.EMPLOYEE)
            ?: throw ResourceNotFoundException("EMPLOYEE role not found")

        newUser.roles.add(employeeRole.toEntity())

        return employeeRepository.save(
            Employee(
                firstName = employeeDto.firstName,
                lastName = employeeDto.lastName,
                hireDate = employeeDto.hireDate,
                department = department,
                user = newUser
            )
        )
    }

    override fun getEmployeeById(id: Long): EmployeeDto? =
        employeeRepository.findById(id).orElse(null)?.toDto()

    override fun getAllEmployees(): List<EmployeeDto> =
        employeeRepository.findAll().toDtoList()

    override fun deleteEmployee(id: Long) =
        employeeRepository.deleteById(id)
}
