package org.example.shopping_cart.controllers;

import org.example.shopping_cart.models.Product;
import org.example.shopping_cart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
@ModelAttribute("cart")
public List<Product> initSession(){
    return new ArrayList<>();
}
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showListProduct(Model model){
        List<Product> productList = iProductService.getAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/cart/{id}")
    public String addToCart(@PathVariable("id") Integer id, @ModelAttribute("cart") List<Product> cartList) {
        Product product = iProductService.findById(id);
        int count = 0;
        for (Product product1: cartList){
            if(product1.getIdProduct().equals(id)){
                product1.setQuantity(product1.getQuantity() + 1);
                count++;
                break;
            }
        }
        if(count == 0){
            cartList.add(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/cart/{action}/{id}")
    public String increaseQuantity(@PathVariable("action")String action, @PathVariable("id")Integer id, Model model, @ModelAttribute("cart")List<Product> productList){
        int number = 0;
        switch (action) {
            case "increase":
                number = 1;
                break;
            case "decrease":
                number = -1;
                break;
        }

        for (Product product: productList){
            if(product.getIdProduct().equals(id)){
                if(number == -1 && product.getQuantity().equals(1)){
                    break;
                }
                product.setQuantity(product.getQuantity() + number);
                break;
            }
        }
        return "redirect:/cart-list";
    }


}
