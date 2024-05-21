package org.example.springmvc.controller;

import java.util.Arrays;
import java.util.List;
import org.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// http://localhost/users 사용자 목록을 출력하세요.
// 사용자 목록에서 사용자, 관리자 여부
// -- 이 값을 메시지프로퍼티를 이용해서 출력하도록 작성
// Countroller나 메서드명은 원하는대로 작성해도 좋습니다.

@Controller
public class UserController {
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("userList", users());
        return "userList";
    }

    private List<User> users() {
        List<User> userList = Arrays.asList(
//          new User("권뭉치", true),
//          new User("권건형", false),
//          new User("권까루", true)
        );
        return userList;
    }
}
