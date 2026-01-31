package service;

import Exception.InvalidInputException;
import model.BookBase;
import repository.BookRepository;
import java.util.List;

public class BookService {
    private final BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    public void createBook(BookBase book) {
        if (book.getName() == null || book.getName().trim().isEmpty()) {
            throw new InvalidInputException("Кітап атауы бос болмауы керек!");
        }
        repository.create(book);
    }

    public List<BookBase> getBooksSortedByName() {

        List<BookBase> books = repository.getAll();

        if (books != null) {
            books.sort((b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName()));
        }

        return books;
    }

    public List<BookBase> getAllBooks() {
        return repository.getAll();
    }
}