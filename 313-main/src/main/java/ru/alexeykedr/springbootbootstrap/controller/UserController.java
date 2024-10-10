package ru.alexeykedr.springbootbootstrap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexeykedr.springbootbootstrap.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "login")
    public String loginPage() {
        logger.info("Login page accessed");
        return "users/login";
    }

    @GetMapping("user")
    public String showUserInfo(@AuthenticationPrincipal User user, Model model) {
        logger.info("User: {}", user.getLogin());
        model.addAttribute("user", user);
        return "users/userPage";
    }
}
