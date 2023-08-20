package gr.aueb.cf.books_demo.controller.exceptions;

public class IllegalFieldException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalFieldException(String message) {
        super(message);
    }
}
