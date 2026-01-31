package controller;

import model.BookBase;
import model.PhysicalBook;
import model.Author;
import service.BookService;
import utils.ReflectionUtils;

import java.util.Scanner;

public class LibraryController {
    private final BookService service;
    private final Scanner scanner;

    public LibraryController(BookService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        ReflectionUtils.inspectClass(PhysicalBook.class);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. List Sorted by Name (Lambda)");
            System.out.println("0. Exit");
            System.out.print("Select: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createBookProcess();
                case "2" -> service.getAllBooks().forEach(BookBase::displayInfo);
                case "3" -> service.getBooksSortedByName().forEach(BookBase::displayInfo); // Lambda нәтижесі
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void createBookProcess() {
        try {
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Author Name: ");
            String authorName = scanner.nextLine();

            System.out.print("Enter Weight (grams): ");
            int weight = Integer.parseInt(scanner.nextLine());

            Author author = new Author(authorName);
            PhysicalBook book = new PhysicalBook(0, name, author, weight);

            service.createBook(book);
            System.out.println("Book created successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}