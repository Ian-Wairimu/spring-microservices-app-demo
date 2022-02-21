package com.wairimuianmoon.department.services;

import com.wairimuianmoon.department.entity.Department;
import com.wairimuianmoon.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department findDepartment(Long departmentId) {
        return repository.findByDepartmentId(departmentId);
    }
}
