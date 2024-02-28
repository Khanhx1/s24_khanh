package org.example.ss9_aop.controllers;

import org.example.ss9_aop.models.Book;
import org.example.ss9_aop.services.IBookService;
import org.example.ss9_aop.services.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    private IBorrowingService iBorrowingService;

    public BookController(@Qualifier("borrowingService") IBorrowingService iBorrowingService) {
        this.iBorrowingService = iBorrowingService;
    }

    @GetMapping("")
    public String showListBook(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list_book";
    }

    @GetMapping("/detail/{id}")
    public String ShowDetailPage(@PathVariable("id") Integer id, Model model) {
        Book book = iBookService.getBookById(id);
        model.addAttribute("book", book);
        return "detail_book";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Integer id, Model model) {
        String message = "";
        if(iBookService.checkQuantity(id)){
            message = "Successfully";
            iBookService.borrowBook(id);
            Book book = iBookService.getBookById(id);
            Integer randomCode = iBorrowingService.addBorrowing(book);
            model.addAttribute("randomCode", randomCode);

        } else {
            message = "Failure";
            model.addAttribute("randomCode", "Not available");
        }
        model.addAttribute("message", message);
        return "random_code";
    }

    @GetMapping("/give-back")
    public String showGiveBackPage() {
        return "give_back_book";
    }

    @PostMapping("/give-back")
    public String giveBookBack(@ModelAttribute("giveBackCode") Integer randomCode, Model model) {
        Integer idBook = iBorrowingService.findIdBook(randomCode);
        String message = null;
        if (idBook != null) {
            iBookService.giveBack(idBook);
            iBorrowingService.deleteBorrowing(randomCode);
            message = "Successfully";
        } else {
            message = "Code is not valid";
        }
        model.addAttribute("message", message);
        return "give_back_book";
    }
}
