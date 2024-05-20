package org.example.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", "어서와~ 아아 먹을래??");
        List<Item> items = Arrays.asList(
                new Item("pen", 1000),
                new Item("keyboard", 50000),
                new Item("ipad", 123000)
        );
        model.addAttribute("itemList",items);
        return "welcome";
    }

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"Apple", 1.20),
            new Product(2,"Banana", 0.75),
            new Product(1,"Cherry", 2.05)
    ));

    @GetMapping("/products")
    public String product(Model model) {
        model.addAttribute("products",products);
        return "productList";
    }

    // Product를 적절히 정의하고,
    // url = /products 요청하면 응답되도록 메서드를 정의하세요.

    @GetMapping("/example")
    public String showExam(Model model) {
        model.addAttribute("username","carami");
        model.addAttribute("isAdmin", true);
        model.addAttribute("languages", new String[]{"English", "Spanish", "German"});
        return "exam";
    }
}
