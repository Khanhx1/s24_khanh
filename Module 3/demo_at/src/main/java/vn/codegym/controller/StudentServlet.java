package vn.codegym.controller;

import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;
import vn.codegym.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 12/29/2023
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    private IStudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                getCreatePage(req, resp);
                break;
            case "edit":
                break;
            default:
                //list
                getStudentList(req, resp);
        }
    }

    private void getCreatePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/student/create.jsp");
    }

    private void getStudentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentList", service.findAll());
        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                break;
            default:
                //list
                getStudentList(req, resp);
        }
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("studentId"));
        String name = req.getParameter("studentName");
        int gender = Integer.parseInt(req.getParameter("studentGender"));
        int point = Integer.parseInt(req.getParameter("studentPoint"));
        String image = req.getParameter("studentImage");

        Student student = new Student(id, name, gender, point, image);
        System.out.println(student);
        service.save(student);
        req.setAttribute("ms", "Tao moi student "+name+" thanh cong.");

//        resp.sendRedirect("/student");
        getStudentList(req, resp);

    }
}