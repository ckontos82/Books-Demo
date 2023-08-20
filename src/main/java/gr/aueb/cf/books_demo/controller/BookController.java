package gr.aueb.cf.books_demo.controller;

import gr.aueb.cf.books_demo.model.Book;
import gr.aueb.cf.books_demo.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String viewBooks(Model model) {
        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
public String addBook(
        @RequestParam String title,
        @RequestParam String author,
        @RequestParam double price,
        Model model
    ) {
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);

        bookService.addBook(b);

        var books =bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }

}
