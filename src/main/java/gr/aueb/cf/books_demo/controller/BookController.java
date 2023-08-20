package gr.aueb.cf.books_demo.controller;

import gr.aueb.cf.books_demo.controller.exceptions.IllegalFieldException;
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
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Double price,
            Model model
    ) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty() || price == null || price <= 0   ) {
            throw new IllegalFieldException("Title and Author fields cannot be empty, and Price must be greater than 0!");
        }
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);

        bookService.addBook(b);

        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }
}
