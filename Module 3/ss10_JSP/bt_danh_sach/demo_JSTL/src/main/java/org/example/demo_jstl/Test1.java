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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        String pathImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Person_icon_BLACK-01.svg/1924px-Person_icon_BLACK-01.svg.png";
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Van Hoan", "1983-08-20", "Ha Noi", pathImage));
        customerList.add(new Customer("Nguyen Van Nam", "1970-08-20", "Bac Giang", pathImage));
        customerList.add(new Customer("Nguyen Thai Hoa", "2000-07-12", "Ha Tinh", pathImage));
        customerList.add(new Customer("Tran Dang Khoa", "1975-08-28", "Da Nang", pathImage));
        customerList.add(new Customer("Nguyen Dinh Thi", "1986-05-11", "Hue", pathImage));

        String headingTable = " <tr>" +
                "<th>Ten</th>" +
                "<th>Ngay sinh</th>" +
                "<th>Dia chi</th>" +
                "<th>Anh</th>" +
                "</tr>";

        req.setAttribute("cList", customerList);
        req.setAttribute("heading",headingTable);
        requestDispatcher.forward(req, resp);


    }
}
