package model;

public abstract class BookBase implements Validatable, PricedItem {
    private int id;
    private String name;
    private Author author;

    public BookBase(int id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Title: " + name + ", Author: " + author.getFullName());
    }

    // Abstract methods
    public abstract String getBookType();
    public abstract void applyDiscount(double percentage);

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public Author getAuthor() { return author; }
    public void setName(String name) { this.name = name; }
}