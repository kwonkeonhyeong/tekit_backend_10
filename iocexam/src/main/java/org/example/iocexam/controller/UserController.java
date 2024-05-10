package org.example.iocexam.controller;

import org.example.iocexam.domain.User;
import org.example.iocexam.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void joinUser() {
        // 실제 동작할 떄는 사용자로부터 정보를 받아온다.
        User user = new User();
        user.setName("kwon");
        user.setEmail("rjsgud1956@gmail.com");
        user.setPassword("1234");
        userService.joinUser(user);
    }
}
