package gr.aueb.cf.books_demo.controller.exceptions;

import gr.aueb.cf.books_demo.service.IBookService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final IBookService bookService;

    @Autowired
    public GlobalExceptionHandler(IBookService bookService) {
        this.bookService = bookService;
    }

    @ExceptionHandler(IllegalFieldException.class)
    public String handleEmptyFieldException(IllegalFieldException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());

        // Retrieve the list of books and add them to the model
        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }
}

