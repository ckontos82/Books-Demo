package gr.aueb.cf.books_demo.controller;

import gr.aueb.cf.books_demo.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    private final IBookService bookService;

    public DeleteController(IBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books/delete", method = RequestMethod.POST)
    public String deleteBook(@RequestParam String bookId, Model model) {
        bookService.deleteBook(bookId);

        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }
}
