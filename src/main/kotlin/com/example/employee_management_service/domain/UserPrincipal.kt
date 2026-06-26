package com.example.employee_management_service.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserPrincipal(
    val user: User
) : UserDetails {

    val email: String get() = user.email

    override fun getUsername(): String = user.username
    override fun getPassword(): String = user.password
    override fun getAuthorities(): Collection<GrantedAuthority> =
        user.roles.map { SimpleGrantedAuthority("ROLE_${it.name}") }
    override fun isEnabled(): Boolean = user.enabled
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
}
