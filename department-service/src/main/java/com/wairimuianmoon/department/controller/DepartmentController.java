package com.wairimuianmoon.department.controller;

import com.wairimuianmoon.department.entity.Department;
import com.wairimuianmoon.department.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return this.service.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable("id") Long departmentId){
        return this.service.findDepartment(departmentId);
    }

}
