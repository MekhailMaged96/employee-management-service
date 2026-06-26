package com.example.employee_management_service.controller

import com.example.employee_management_service.dto.DepartmentDto
import com.example.employee_management_service.service.DepartmentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/departments")
class DepartmentController(private  val departmentService: DepartmentService) {

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Long): ResponseEntity<DepartmentDto> {
        return ResponseEntity.ok(departmentService.getDepartmentById(id) ?: return ResponseEntity.notFound().build())
    }

    @GetMapping
    fun getAllDepartments(): ResponseEntity<List<DepartmentDto>> {
        return ResponseEntity.ok(departmentService.getAllDepartments())
    }

    @PostMapping
    fun createDepartment(@RequestBody departmentDto: DepartmentDto): ResponseEntity<DepartmentDto> {
        val createdDepartment = departmentService.createDepartment(departmentDto)
        return ResponseEntity.status(201).body(createdDepartment)
    }
}