package com.codegym.demo_springboot.controller;

import com.codegym.demo_springboot.model.ClassRoom;
import com.codegym.demo_springboot.model.Student;
import com.codegym.demo_springboot.service.IClassService;
import com.codegym.demo_springboot.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/student")
@SessionAttributes("studentTalkList")
public class StudentController{

    @Autowired
    private IClassService iClassService;

    @ModelAttribute("studentTalkList")
    public List<Student> initStudentTalkList() {
        return new ArrayList<>();
    }

    @GetMapping("/addTalk/{code}")
    public String addTalk(@PathVariable("code")Integer code,
                          @ModelAttribute("studentTalkList")List<Student> studentTalkList,
                          RedirectAttributes redirect) {
        Student student = iStudentService.getStudentById(code);
        studentTalkList.add(student);
        redirect.addFlashAttribute("msg", "Thêm học sinh vào room thành công");
        return "redirect:/student";
    }

    //DI
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    //    @RequestMapping(value = "",method = RequestMethod.GET)
    @GetMapping(value = "")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {

        Page<Student> studentList = iStudentService.getAll(PageRequest.of(page, 2));
        model.addAttribute("listStudent", studentList);
        return "list";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/create")
    public String showPageCreate(Model model) {
        model.addAttribute("classrooms", iClassService.findAll());
        model.addAttribute("student", new Student(0,"", 0.0, 0));
        model.addAttribute("listGender", new String[] {"0","1","2"});
        return "create";
    }

    @GetMapping("/detail")
    public ModelAndView showDetailByParam(@RequestParam("id") Integer codeStudent) {
//        Student student = iStudentService.getStudentById(codeStudent);
//        model.addAttribute("student", student);
//        return "detail";
        return new ModelAndView("detail", "student", iStudentService.getStudentById(codeStudent));
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailByPathVariable(@PathVariable("id") Integer codeStudent) {
//        Student student = iStudentService.getStudentById(codeStudent);
//        model.addAttribute("student", student);
//        return "detail";
        return new ModelAndView("detail", "student", iStudentService.getStudentById(codeStudent));
    }



    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/create")
    public String addStudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult,
                             RedirectAttributes redirect, Model model) {
//        new Student().validate(student, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("classrooms", iClassService.findAll());
            return "create";
        }

       iStudentService.save(student);
       redirect.addFlashAttribute("msg", "Thêm mới thành công");
       return "redirect:/student";
    }



    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }

}
