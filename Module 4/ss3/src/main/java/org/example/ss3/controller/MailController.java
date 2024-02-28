package org.example.ss3.controller;

import org.example.ss3.models.MailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {

    @GetMapping
    public String showMailSettingPage(Model model){
        model.addAttribute("mailConfig", new MailConfig("English", "25", false, "Khanh"));
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new String[]{"5", "10", "15", "25", "50", "100"});
        return "setting";
    }

    @PostMapping("save")
    public String showMailConfig(@ModelAttribute MailConfig mailConfig, Model model){
        model.addAttribute("language", mailConfig.getLanguage());
        model.addAttribute("pageSize", mailConfig.getPageSize());
        model.addAttribute("SpamFilter", mailConfig.getSpamFilter());
        model.addAttribute("signature", mailConfig.getSignature());
        return "configPage";
    }
}
