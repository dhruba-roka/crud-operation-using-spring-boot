package com.dhruba.crud_demo.controller;

import com.dhruba.crud_demo.model.Books;
import com.dhruba.crud_demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BooksController {

    //autowire the BooksService class
    @Autowired
    private BooksService booksService;

    //Home-Page that shows all the books details-->Read
    @GetMapping("/")
    public String homepage(Model model){

        List<Books> listBooks= booksService.listAll();
        model.addAttribute("listBooks",listBooks);
        return "index";
    }

    //add new book-->create
    @GetMapping ("/add-book")
    private String addNewBook(Model model)
    {

        Books books = new Books();
        model.addAttribute("books",books);
        return "addnew-books";
    }
    //saving new books
    @GetMapping("/save")
    public String saveBooks(@ModelAttribute("books") Books books){
      booksService.save(books);
      return "redirect:/";
    }
    //update a book-->update
    @GetMapping ("/edit-book/{bookid}")
    private ModelAndView editBook(@PathVariable(name="bookid") int bookid)
    {
        ModelAndView mv = new ModelAndView("edit_book");
        Books books = booksService.get(bookid);
        mv.addObject("books",books);


        return mv;
    }

    //delete book-->Delete
    @GetMapping("/delete-book/{bookid}")
    private String delete(@PathVariable(name="bookid") int bookid){
        booksService.delete(bookid);
        return "redirect:/";
    }

}
