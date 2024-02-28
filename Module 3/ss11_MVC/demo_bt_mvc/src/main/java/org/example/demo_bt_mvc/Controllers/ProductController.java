package org.example.demo_bt_mvc.Controllers;

import org.example.demo_bt_mvc.Services.IProductService;
import org.example.demo_bt_mvc.Services.ProductService;
import org.example.demo_bt_mvc.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("product/create.jsp").forward(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "edit":
                req.setAttribute("id", id);
                req.getRequestDispatcher("product/edit.jsp").forward(req, resp);
                break;
            case "detail":
                detail(req, resp);
                break;
            default:
                showProductList(req, resp);
                break;
        }

    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/showList.jsp");
        req.setAttribute("list", productList);
        requestDispatcher.forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.findById(id);
        req.setAttribute("productDetail", product);
        req.getRequestDispatcher("product/detail.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        productService.remove(id);
        resp.sendRedirect("/product");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creatProduct(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            default:
                showProductList(req, resp);
                break;
        }
    }

    private void creatProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("new id");
        String name = req.getParameter("new name");
        Integer quantity = Integer.valueOf(req.getParameter("new quantity"));
        Integer price = Integer.valueOf(req.getParameter("new price"));
        Product product = new Product(id, name, quantity, price);
        productService.add(product);
        resp.sendRedirect("/product");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("idEdition");
        String newId = req.getParameter("new id");
        String newName = req.getParameter("new name");
        Integer newQuantity = Integer.valueOf(req.getParameter("new quantity"));
        Integer newPrice = Integer.valueOf(req.getParameter("new price"));
        productService.edit(id, newId, newName, newQuantity, newPrice);
        resp.sendRedirect("/product");
    }
}
