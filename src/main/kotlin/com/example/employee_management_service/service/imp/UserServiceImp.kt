package com.example.employee_management_service.service.imp

import com.example.employee_management_service.domain.User
import com.example.employee_management_service.dto.CreateUserDto
import com.example.employee_management_service.repository.UserRepository
import com.example.employee_management_service.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImp(private val userRepository: UserRepository) : UserService
{
    override fun createUser(user: CreateUserDto): User {
        val newUser = User(
            username = user.username,
            email = user.email,
            password = user.password
        )
        return userRepository.save(newUser)
    }

    override fun getById(id: Long): User? =
        userRepository.findById(id).orElse(null)


    override fun getAll(): List<User> {
        return userRepository.findAll()
    }

    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }
}