package com.wairimuianmoon.user.controller;

import com.wairimuianmoon.user.entity.User;
import com.wairimuianmoon.user.services.UserService;
import com.wairimuianmoon.user.valueObject.ResponseTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Controller {
    private final UserService service;

    public Controller(UserService service) {
        this.service = service;
    }
    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplate getUserDepartment(@PathVariable("id") Long userId){
        return this.service.getUserDepartment(userId);
    }
    @Getmapping("/users/{user}")
    public User getUsers(@pathVariable("username") String name){
        return this.servcie.getUsers(name);
    }
}
