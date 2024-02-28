package org.example.ss2_spring_bt_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public String showCalculator() {
        return "calculatorPage";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(defaultValue = "0") double first, @RequestParam(defaultValue = "0") double second, @RequestParam("function") String function, RedirectAttributes redirectAttributes) {
        double result = 0.0d;
        switch (function){
            case "addition":
                result = first + second;
                break;
            case "subtraction":
                result = first - second;
                break;
            case "multiplication":
                result = first * second;
                break;
            case "division":
                result = first / second;
                break;
        }
        redirectAttributes.addFlashAttribute("result", result);
        redirectAttributes.addFlashAttribute("function", function);
        redirectAttributes.addFlashAttribute("first", first);
        redirectAttributes.addFlashAttribute("second", second);
        return "redirect:/calculator";
    }
}
