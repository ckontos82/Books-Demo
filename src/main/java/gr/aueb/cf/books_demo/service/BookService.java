package gr.aueb.cf.books_demo.service;

import gr.aueb.cf.books_demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> findAll() {
        return bookList;
    }

    public void deleteBook(String bookId) {
        bookList.removeIf(book -> book.getId().equals(bookId));
    }
}
