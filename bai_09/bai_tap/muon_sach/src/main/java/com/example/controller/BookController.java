package com.example.controller;

import com.example.model.Book;
import com.example.model.BorrowBook;
import com.example.service.IBookService;
import com.example.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBookService iBorrowBookService;

    @GetMapping(value = "/book/list")
    public String list(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("bookList", iBookService.findAllByNameContaining(keywordVal, pageable));
        return "/book/list";
    }

    @GetMapping(value = "/book/create")
    public String create(Model model, Book book) {

        model.addAttribute("book", book);
        return "/book/create";
    }

    @PostMapping(value = "/book/create")
    public String create(Book book, RedirectAttributes redirectAttributes) {

        iBookService.save(book);
        redirectAttributes.addFlashAttribute("mess", "da them moi thanh cong");
        return "redirect:/book/list";
    }

    @GetMapping(value = "/book/borrow/{id}")
    public String borrow(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/book/borrow";
    }

    @PostMapping(value = "/book/borrow")
    public String borrow(Book book) {
        Book newBook = this.iBookService.findById(book.getId());
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setIdBorrow((int) (Math.random() * 89999) + 10000);
        borrowBook.setBook(newBook);
        newBook.setQuantity(newBook.getQuantity() - 1);
        this.iBorrowBookService.save(borrowBook);
        return "redirect:/book/list";
    }

    @GetMapping(value = "/book/pay")
    public String showPay() {


        return "/book/pay";
    }

    @PostMapping(value = "/book/pay")
    public String pay(@RequestParam Integer pay) {

        BorrowBook borrowBook = iBorrowBookService.findById(pay);
        borrowBook.getBook().setQuantity(borrowBook.getBook().getQuantity() + 1);
        this.iBorrowBookService.remove(borrowBook);
        return "redirect:/book/list";
    }

}
