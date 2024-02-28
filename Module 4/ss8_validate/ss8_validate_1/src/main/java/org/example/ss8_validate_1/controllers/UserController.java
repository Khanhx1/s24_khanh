package org.example.ss8_validate_1.controllers;

import org.example.ss8_validate_1.models.User;
import org.example.ss8_validate_1.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showSignInForm(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/create")
    public String addNewUser(@Validated @ModelAttribute("user")User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        iUserService.add(user);
        return "result";
    }
}
