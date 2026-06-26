package com.example.employee_management_service.service

import com.example.employee_management_service.domain.User

interface UserService {

    fun createUser(user: User): User
    fun getById(id: Long): User?
    fun getAll(): List<User>
    fun delete(id: Long)
    fun getUserByEmail(email: String): User?
}