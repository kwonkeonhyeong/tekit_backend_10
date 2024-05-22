package org.example.springmvcexam.controller;

import java.util.Arrays;
import java.util.List;
import org.example.springmvcexam.domain.Friend;
import org.example.springmvcexam.domain.FriendsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendController {
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        List<Friend> friends = Arrays.asList(
                new Friend("1", "뭉치", "mong@naver.com"),

                new Friend("2", "건형", "rjsgud1956@google.com"),
                new Friend("3", "까루", "dark@nate.com")
        );
        model.addAttribute("friends");
//        model.addAttribute()
        return "signup";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute Friend friend, FriendsService friendsService) {
        friendsService.saveFriends(friend);
        return "signup";
    }
}
