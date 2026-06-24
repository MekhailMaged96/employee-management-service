package com.example.employee_management_service.service.imp
import com.example.employee_management_service.domain.Employee
import com.example.employee_management_service.dto.CreateEmployeeDto
import com.example.employee_management_service.repository.*
import com.example.employee_management_service.service.EmployeeService
import org.springframework.stereotype.Service


@Service
class EmployeeServiceImp (
                          private val employeeRepository: EmployeeRepository,
                          private val roleRepository: RoleRepository,
                          private val departmentRepository: DepartmentRepository) : EmployeeService
{

    // Implement the methods of EmployeeService here
    override fun createEmployee(employeeDto: CreateEmployeeDto): Employee {
        val department = departmentRepository.findById(employeeDto.departmentId)
            .orElseThrow { RuntimeException("Department not found") }

        return employeeRepository.save(
            Employee(
                firstName = employeeDto.firstName,
                lastName = employeeDto.lastName,
                hireDate = employeeDto.hireDate,
                department = department
            )
        )
    }

    override fun getEmployeeById(id: Long): Employee? = employeeRepository.findById(id).orElse(null)


    override fun getAllEmployees(): List<Employee> {
       return  employeeRepository.findAll()
    }

    override fun deleteEmployee(id: Long) {
        employeeRepository.deleteById(id)
    }
}