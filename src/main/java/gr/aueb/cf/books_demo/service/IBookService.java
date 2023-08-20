package gr.aueb.cf.books_demo.service;

import gr.aueb.cf.books_demo.model.Book;

import java.util.List;

public interface IBookService {
    public void addBook(Book book);
    public List<Book> findAll();
    public void deleteBook(String bookId);
}
