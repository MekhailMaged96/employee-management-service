package com.example.employee_management_service.controller

import com.example.employee_management_service.domain.Employee
import com.example.employee_management_service.dto.CreateEmployeeDto
import com.example.employee_management_service.dto.EmployeeDto
import com.example.employee_management_service.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @PostMapping("/create")
    fun createEmployee(@RequestBody dto: CreateEmployeeDto): ResponseEntity<Employee> {
        val employee = employeeService.createEmployee(dto)
        return ResponseEntity.status(201).body(employee)
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<EmployeeDto> {
        val employee = employeeService.getEmployeeById(id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(employee)
    }

    @GetMapping
    fun getAllEmployees(): ResponseEntity<List<EmployeeDto>> {
        return ResponseEntity.ok(employeeService.getAllEmployees())
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Void> {
        employeeService.deleteEmployee(id)
        return ResponseEntity.noContent().build()
    }
}
