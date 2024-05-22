package org.example.springmvcexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }
}

// 1. form으로 친구 등록 완료하면 등록하는 페이지로 리다이렉트
// 2. 친구정보를 friend객체로 받아오는 @ModelAttribute 사용해서 폼데이터 받아오고 저장
// 3. Thymeleaf로 친구 list 보여주기
// ??? 모르겠다