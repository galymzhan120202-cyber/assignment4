package model;

public interface Validatable {

    void validate();

    default void logValidation() {
        System.out.println("Validation process started...");
    }

    static boolean isPositive(double value) {
        return value > 0;
    }
}