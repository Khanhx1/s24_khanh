package org.example.demo_jstl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/a")
public class CalculatorServlet extends HttpServlet {
    private Calculator calculator = new Calculator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        Float first = Float.valueOf(req.getParameter("first operand"));
        Float second = Float.valueOf(req.getParameter("second operand"));
        String operator = req.getParameter("operator");
        Float result = 0.0f;
        try {
            result = calculator.calculate(first, second, operator);
        } catch (Exception e) {
            req.setAttribute("message", "invalid number");
        }
        req.setAttribute("result", result);
        requestDispatcher.forward(req, resp);
    }
}
