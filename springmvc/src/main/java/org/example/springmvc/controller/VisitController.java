package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
    @GetMapping("/visit")
    public String showVisit(
            @CookieValue(name="lastVisit", defaultValue = "N/A") String lastVisit,
            HttpServletResponse response, Model model, HttpServletRequest request) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String encodedTime = "error";
        try {
            // 쿠키 값엔 공백이 있으면 안된다. URLEncoder를 이용
            encodedTime = URLEncoder.encode(currentTime, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        Cookie cookie = new Cookie("lastVisit", encodedTime);
        cookie.setMaxAge(24 * 60 * 60); // 쿠키 유효기간 1일 설정
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("UserId", encodedTime);
        cookie2.setMaxAge(24 * 60 * 60); // 쿠키 유효기간 1일 설정
        response.addCookie(cookie2);

        model.addAttribute("currentTime", currentTime);
        model.addAttribute("lastVisit", lastVisit);

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.print(c.getName() + " ::: ");
            System.out.println(c.getValue());
        }

        return "visit";
    }
}
