package org.example.ss2_bt_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/condiment")
public class CondimentController {

    @GetMapping
    public String showCondiment(){
        return "listCondiment";
    }

    @PostMapping("/save")
    public String saveCondiment(@RequestParam("condiment")String[] condiments, RedirectAttributes redirect){
        redirect.addFlashAttribute("result", condiments);
        return "redirect:/condiment";
    }

}
