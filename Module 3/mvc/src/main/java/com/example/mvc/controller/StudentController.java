package com.example.mvc.controller;

import com.example.mvc.model.Student;
import com.example.mvc.service.IStudentService;
import com.example.mvc.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("student/create.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                req.getRequestDispatcher("student/edit.jsp").forward(req, resp);
                break;
            default:
                showStudentList(req, resp);
                break;
        }
    }

    private void showStudentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // show list
        List<Student> students = this.studentService.getAllStudent();
        req.setAttribute("students", students);
        req.setAttribute("g","vao get");
        req.getRequestDispatcher("student/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            default:
                showStudentList(req, resp);
                req.setAttribute("p","vao post");
                break;
        }
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double point = Double.parseDouble(req.getParameter("point"));
        Student student = new Student(id, name, point);
        this.studentService.save(student);
        resp.sendRedirect("/student");
    }
}
