package com.example.passmd4.controller;

import com.example.passmd4.model.QuocGia;
import com.example.passmd4.service.IQuocGiaService;
import com.example.passmd4.service.IThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quocgia")
public class QuocGiaController {
    @Autowired
    IThanhPhoService iThanhPhoService;
    @Autowired
    IQuocGiaService iQuocGiaService;
    @GetMapping("/list")
    public ModelAndView showListQuocGia(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("quocgia-list","quocgia",iQuocGiaService.findAllQuocGia(pageable));
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add-quocgia", "quocgia", new QuocGia());
    }
    @PostMapping("/add")
    public String saveCategory(@ModelAttribute QuocGia quocGia) {
        iQuocGiaService.createQuocGia(quocGia);
        return "redirect:/quocgia/list";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id) {
        return new ModelAndView("edit-quocgia", "quocgia", iQuocGiaService.findQuocGiaById(id));
    }

    @PostMapping("/{id}/edit")
    public String updateCategory(@ModelAttribute QuocGia quocGia) {
        iQuocGiaService.updateQuocGia(quocGia);
        return "redirect:/quocgia/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCage(@PathVariable Integer id){
        iQuocGiaService.deleteQuocGia(id);
        return "redirect:/quocgia/list";
    }
}
