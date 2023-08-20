package gr.aueb.cf.books_demo.model;

import java.util.Objects;
import java.util.UUID;

public class Book {
    private String title;
    private String author;
    private double price;
    private final String id;

    public Book() {
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }
}
