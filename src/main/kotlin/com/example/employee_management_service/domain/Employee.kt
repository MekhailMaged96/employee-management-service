package com.example.employee_management_service.domain

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "employees")
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var firstName: String,

    @Column(nullable = false)
    var lastName: String,

    var phone: String? = null,

    var jobTitle: String? = null,

    var hireDate: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    var department: Department,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

)
