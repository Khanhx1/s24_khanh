package org.example.demo_jstl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Test1", value = "/a")
public class Test1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        Float first = Float.valueOf(req.getParameter("first operand"));
        Float second = Float.valueOf(req.getParameter("second operand"));
        String operator = req.getParameter("operator");

        Float result = 0.0f;
        try {
            switch (operator) {
                case "add":
                    result = first + second;
                    break;
                case "minus":
                    result = first - second;
                    break;
                case "multiplication":
                    result = first * second;
                    break;
                case "division":
                    if (second == 0) {
                        throw new Exception("invalid number");
                    } else {
                        result = first / second;
                    }
                    break;
                default:
                    throw new Exception("invalid operator");
            }
        } catch (Exception e) {
            req.setAttribute("message", "invalid number");
        }
        req.setAttribute("result", result);
        requestDispatcher.forward(req, resp);
    }
}
