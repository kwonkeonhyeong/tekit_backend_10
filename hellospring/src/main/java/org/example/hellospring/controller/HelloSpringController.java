package org.example.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @GetMapping("/")
    public String hello() {
        return "home에 오신걸 환영합니다.";
    }
    @GetMapping("/lunch")
    public String lunch() {
        return "점심먹으러 가는 페이지입니다.";
    }
    @GetMapping("/happy")
    public String happy() {
        return "점심먹으러 가서 기분이 좋아지는 페이지입니다.";
    }
}
