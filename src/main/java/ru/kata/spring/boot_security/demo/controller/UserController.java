package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.DetailService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private DetailService detailService;

    @Autowired
    public UserController(UserService userService, DetailService detailService) {
        this.userService = userService;
        this.detailService = detailService;
    }

    @GetMapping("/info")
    public String edit(Model model, Principal principal) {
        model.addAttribute("user",
                detailService.loadUserByUsername(principal.getName()));
        return "user";
    }
}
