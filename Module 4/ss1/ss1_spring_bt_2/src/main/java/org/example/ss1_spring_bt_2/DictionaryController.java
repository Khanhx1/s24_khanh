package org.example.ss1_spring_bt_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @GetMapping
    public String showDictionary(){
        return "dictionary";
    }

    @GetMapping("/translate")
    public String translate(HttpServletRequest req, Model model){
        String eng = req.getParameter("eng");
        String[] engArr = {"go","run","walk", "fly", "jump",};
        String[] vietNamArr = {"đi","chay","đi bộ", "bay", "nhảy",};
        String resultVN = null;
        String resultENG = null;
        int count = 0;

        if(eng != "") {
            for (int i = 0; i < engArr.length; i++) {
                if (engArr[i].equals(eng)) {
                    count++;
                    resultVN = vietNamArr[i];
                    resultENG = engArr[i];
                    model.addAttribute("resultVN", resultVN);
                    model.addAttribute("resultENG", resultENG);
                    break;
                }
            }
            if (count == 0) {
                model.addAttribute("resultVN", "Không tìm thấy");
            }
        } else {
            model.addAttribute("resultVN","");
        }
        return "dictionary";
    }
}
