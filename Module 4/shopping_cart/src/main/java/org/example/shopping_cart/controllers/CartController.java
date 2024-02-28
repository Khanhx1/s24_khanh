package org.example.shopping_cart.controllers;

import org.example.shopping_cart.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/cart-list")
public class CartController {

    @GetMapping("")
    public String showCartPage(Model model, @SessionAttribute("cart")List<Product> productList){
        Integer total = 0;
        for (Product product: productList){
            total += product.getPrice()*product.getQuantity();
        }
        model.addAttribute("productList", productList);
        model.addAttribute("total", total);
        return "cart_page";
    }
}
