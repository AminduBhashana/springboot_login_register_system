package com.example.login_register_system.controllers;

import com.example.login_register_system.entity.User;
import com.example.login_register_system.repository.UserRepository;
import com.example.login_register_system.utils.PasswordUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("register")
    public RedirectView register(@ModelAttribute User user, HttpSession session) {
        user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
        userRepository.save(user);
        session.setAttribute("message", "User Registration Successful!");

        return new RedirectView("/");
    }

    @PostMapping("login")
    public RedirectView login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            session.setAttribute("error", "Invalid email or password!");
            return new RedirectView("/login");
        }

        boolean isValid = PasswordUtils.checkPassword(password, user.getPassword());
        if (isValid) {
            session.setAttribute("user", user);
            session.setAttribute("message", "Login Successful!");

            return new RedirectView("/welcome");
        } else {
            session.setAttribute("error", "Invalid email or password!");
            return new RedirectView("/login");
        }
    }

    @GetMapping("clearMessage")
    @ResponseBody
    public void clearMessage(HttpSession session) {
        session.removeAttribute("message");
    }
}
