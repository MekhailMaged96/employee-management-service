package com.example.employee_management_service.dto

import com.example.employee_management_service.domain.Role
import com.example.employee_management_service.mapper.toDto

data class RoleDto (
    val id: Long?,
    val name: String)


fun RoleDto.toEntity(): Role {
    return Role(
        id = this.id,
        name = this.name
    )
}

fun Role.toDto(): RoleDto {
    return RoleDto(
        id = this.id,
        name = this.name
    )
}
