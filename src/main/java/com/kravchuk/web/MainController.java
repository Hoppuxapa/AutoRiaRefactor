package com.kravchuk.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String root(@RequestHeader Map<String, String> headers) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("Hello!");
        return "menu";
    }
    @GetMapping("/user")
    public String userIndex() {
        return "user";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("user/userEdit")
    public String userEdit() {
        return "user/userEdit";
    }
}

