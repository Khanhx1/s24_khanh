package com.example.passmd4.controller;

import com.example.passmd4.model.ThanhPho;
import com.example.passmd4.service.IQuocGiaService;
import com.example.passmd4.service.IThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ThanhPhoController {
    @Autowired
    private IThanhPhoService iThanhPhoService;
    @Autowired
    private IQuocGiaService iQuocGiaService;

    @GetMapping("/thanhpho/list")
    public ModelAndView showHome(
            @RequestParam(value = "thanhphosearch", defaultValue = "") String thanhphosearch,
            @PageableDefault(value = 2, sort = "tenThanhPho", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("thanhphosearch", thanhphosearch);
        if (!thanhphosearch.isEmpty()) {
            return new ModelAndView("list", "thanhphos", iThanhPhoService.searchThanhPhoByTenThanhPhoContaining(thanhphosearch, pageable));
        } else {
            return new ModelAndView("list", "thanhphos", iThanhPhoService.findAllThanhPho(pageable));
        }
    }
    @GetMapping("/thanhpho/add")
    public ModelAndView showFormAdd(Model model) {
        model.addAttribute("quocgia", iQuocGiaService.findAllQuocGia());
        return new ModelAndView("add", "thanhpho", new ThanhPho());
    }

    @PostMapping("/thanhpho/add")
    public String saveBlog(@ModelAttribute ThanhPho thanhPho) {
        iThanhPhoService.createThanhPho(thanhPho);
        return "redirect:/thanhpho/list";
    }
    @GetMapping("/thanhpho/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("quocgia",iQuocGiaService.findAllQuocGia());
        return new ModelAndView("edit","thanhpho", iThanhPhoService.findThanhPhoById(id));
    }
    @PostMapping("/thanhpho/{id}/edit")
    public String updateThanhPho(@ModelAttribute ThanhPho thanhPho){
        iThanhPhoService.updateThanhPho(thanhPho);
        return "redirect:/thanhpho/list";
    }
    @GetMapping("/thanhpho/{id}/delete")
    public String deleteBlog(@PathVariable Integer id){
        iThanhPhoService.deleteThanhPho(id);
        return "redirect:/thanhpho/list";
    }
    @GetMapping("/thanhpho/{id}/view")
    public ModelAndView viewDetailPig(@PathVariable Integer id){
        return new ModelAndView("view","thanhpho", iThanhPhoService.findThanhPhoById(id));
    }
}
