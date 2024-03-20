package com.codegym.demo_springboot.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

//    @GetMapping("/login")
//    public String loginPage(@CookieValue(value = "username", defaultValue = "")String username,
//                            @CookieValue(value = "password", defaultValue = "")String password,
//                            Model model) {
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//        return "loginPage";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
//                        @RequestParam(value = "remember-me", defaultValue = "false")Boolean rememberMe, HttpServletResponse http) {
//        // Login
//        if(rememberMe) {
//            Cookie cookieUsername = new Cookie("username", username);
//            Cookie cookiePassword = new Cookie("password", password);
//            cookieUsername.setMaxAge(3 * 24 * 60 * 60);
//            cookiePassword.setMaxAge(3 * 24 * 60 * 60);
//            http.addCookie(cookieUsername);
//            http.addCookie(cookiePassword);
//        }
//        return "redirect:/student";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, @RequestParam(value = "error", defaultValue = "")String error) {
        model.addAttribute("error", error);
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
}
