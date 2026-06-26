package com.example.employee_management_service.controller

import com.example.employee_management_service.dto.RoleDto
import com.example.employee_management_service.service.RoleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/roles")
class RoleController(private val roleService: RoleService) {

    @GetMapping
    fun getAllRoles(): ResponseEntity<List<RoleDto>> =
        ResponseEntity.ok(roleService.getAllRoles())

    @GetMapping("/{id}")
    fun getRoleById(@PathVariable id: Long): ResponseEntity<RoleDto> {
        val role = roleService.getRoleById(id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(role)
    }

    @GetMapping("/name/{name}")
    fun getRoleByName(@PathVariable name: String): ResponseEntity<RoleDto> {
        val role = roleService.getRoleByName(name)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(role)
    }
}
