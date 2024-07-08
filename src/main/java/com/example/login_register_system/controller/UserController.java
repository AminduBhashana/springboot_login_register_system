package com.example.login_register_system.controller;

import com.example.login_register_system.entity.User;
import com.example.login_register_system.repository.UserRepo;
import com.example.login_register_system.utils.PasswordUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/api/register")
    public String register(@ModelAttribute User user, HttpSession session) {
        System.out.println(user);
        user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
        System.out.println(user);
        userRepo.save(user);
        session.setAttribute("message", "User Registration Successful!");
        return "redirect:/";
    }

    @PostMapping("/api/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userRepo.findByEmail(email);
        boolean isValid = PasswordUtils.checkPassword(password, user.getPassword());
        if (isValid) {
            session.setAttribute("user", user);
            session.setAttribute("message", "Login Successful!");
            return "redirect:/welcome";
        } else {
            session.setAttribute("message", "Invalid email or password!");
            return "redirect:/login";
        }
    }

    @GetMapping("/api/clearMessage")
    @ResponseBody
    public void clearMessage(HttpSession session) {
        session.removeAttribute("message");
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
