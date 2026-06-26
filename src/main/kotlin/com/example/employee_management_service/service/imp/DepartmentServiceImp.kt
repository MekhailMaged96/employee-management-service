package com.example.employee_management_service.service.imp

import com.example.employee_management_service.dto.DepartmentDto
import com.example.employee_management_service.mapper.toDto
import com.example.employee_management_service.mapper.toDtoList
import com.example.employee_management_service.mapper.toEntity
import com.example.employee_management_service.repository.DepartmentRepository
import com.example.employee_management_service.service.DepartmentService
import org.springframework.stereotype.Service


@Service
class DepartmentServiceImp(private  val departmentRepository: DepartmentRepository) : DepartmentService {
    override fun createDepartment(departmentDto: DepartmentDto): DepartmentDto {
        val department = departmentRepository.save(departmentDto.toEntity())
        return department.toDto()
    }

    override fun getDepartmentById(id: Long): DepartmentDto? {
       return departmentRepository.findById(id).orElse(null)?.toDto()
    }

    override fun getAllDepartments(): List<DepartmentDto> {
       return  departmentRepository.findAll().toDtoList()
    }
}