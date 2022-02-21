package com.wairimuianmoon.user.services;

import com.wairimuianmoon.user.entity.User;
import com.wairimuianmoon.user.repository.UserRepository;
import com.wairimuianmoon.user.valueObject.Department;
import com.wairimuianmoon.user.valueObject.ResponseTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final UserRepository repository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public ResponseTemplate getUserDepartment(Long userId) {
        var vo = new ResponseTemplate();
        User user = repository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
