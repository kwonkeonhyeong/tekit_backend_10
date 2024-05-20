package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// @Controller => 응답을 view로 한다.
// @RestController => 응답을 return 값으로 한다.
@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest() {
        return "restbody test!!!!";
    }

    @GetMapping("greeting")
    public String greet(
            @RequestParam(name = "name", required = false, defaultValue = "kang") String name,
            @RequestParam(name = "age", required = true, defaultValue = "30") int age, Model model) {
        //?name=rjsgud&age=20 => 쿼리 문자열
        System.out.println(name);
        System.out.println(age);

        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("greeting2")
    public ModelAndView greet2(
            @RequestParam String name, ModelAndView modelAndView) {
        //?name=rjsgud&age=20 => 쿼리 문자열
        System.out.println(name);

        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");
        return modelAndView;
    }
}
