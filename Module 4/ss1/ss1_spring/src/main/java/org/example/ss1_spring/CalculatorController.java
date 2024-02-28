package org.example.ss1_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String showCalculator() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(HttpServletRequest request, Model model) {
        int usd = Integer.parseInt(request.getParameter("usd"));
        int rate = Integer.parseInt(request.getParameter("rate"));
        model.addAttribute("result", usd * rate);
        return "calculator";
    }
}
