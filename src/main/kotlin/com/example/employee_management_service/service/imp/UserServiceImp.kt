package com.example.employee_management_service.service.imp

import com.example.employee_management_service.domain.User
import com.example.employee_management_service.repository.UserRepository
import com.example.employee_management_service.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImp(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun createUser(user: User): User {

        user.password = passwordEncoder.encode(user.password) ?: user.password

        return userRepository.save(user)
    }

    override fun getById(id: Long): User? =
        userRepository.findById(id).orElse(null)

    override fun getAll(): List<User> =
        userRepository.findAll()

    override fun delete(id: Long) =
        userRepository.deleteById(id)

    override fun getUserByEmail(email: String): User? =
        userRepository.findByEmail(email)
}
