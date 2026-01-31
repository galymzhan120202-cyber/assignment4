package model;

import Exception.InvalidInputException;

public class EBook extends BookBase {
    private double fileSizeMB;
    private double price;

    public EBook(int id, String name, Author author, double fileSizeMB, double price) {
        super(id, name, author);
        this.fileSizeMB = fileSizeMB;
        this.price = price;
    }

    @Override
    public String getBookType() {
        return "Digital E-Book";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void applyDiscount(double percentage) {

        this.price = this.price - (this.price * percentage / 100);
        System.out.println("EBook discount applied. New price: " + this.price);
    }

    @Override
    public void validate() {

        logValidation();

        if (fileSizeMB <= 0) {
            throw new InvalidInputException("Файл өлшемі оң сан болуы керек!");
        }
        if (getName() == null || getName().trim().isEmpty()) {
            throw new InvalidInputException("E-Book атауы бос болмауы керек!");
        }
    }


    public double getFileSizeMB() { return fileSizeMB; }
    public void setFileSizeMB(double fileSizeMB) { this.fileSizeMB = fileSizeMB; }
}