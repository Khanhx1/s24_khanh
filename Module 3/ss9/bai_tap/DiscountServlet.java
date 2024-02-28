package org.example.demo_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ProductDiscountCalculator", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("product description");
        Long listPrice = Long.valueOf(request.getParameter("list price"));
        Double discountPercent = Double.valueOf(request.getParameter("discount percent"));

        Double discountAmount = listPrice * (discountPercent / 100) * 0.01;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product description: " + productDescription + "</h1>");
        writer.println("<h1>List price: " + listPrice + "</h1>");
        writer.println("<h1>Discount percent: " + discountPercent + "</h1>");
        writer.println("<h1>Discount amount: " + discountAmount + "</h1>");
        writer.println("</html>");
    }
}
