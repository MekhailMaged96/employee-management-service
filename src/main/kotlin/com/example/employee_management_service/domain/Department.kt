package com.example.employee_management_service.domain

import jakarta.persistence.*
import jakarta.persistence.*


@Entity
@Table(name = "departments")
class Department (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,

    var description: String?= null,

    @OneToMany(mappedBy = "department")
    var employees: MutableList<Employee> = mutableListOf()

)