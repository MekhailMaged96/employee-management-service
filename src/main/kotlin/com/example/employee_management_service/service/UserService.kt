package com.example.employee_management_service.service

import com.example.employee_management_service.domain.User
import com.example.employee_management_service.dto.CreateUserDto
import org.springframework.boot.webflux.autoconfigure.WebFluxProperties

interface UserService {


    fun createUser (user: CreateUserDto): User
    fun getById(id: Long): User?

    fun getAll(): List<User>

    fun delete(id: Long)
}