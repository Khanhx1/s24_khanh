package org.example.demo.controllers;

import org.example.demo.models.Product;
import org.example.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showProductList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product, Model model){
        productService.add(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String showDetailPage(@PathVariable("id")int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id")int id, Model model){
        productService.remove(id);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id")int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product")Product product, Model model){
        productService.edit(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String searchProduct(@ModelAttribute("search")String search, Model model){
        List<Product> productList = productService.search(search);
        model.addAttribute("productList", productList);
        return "list";
    }
}
