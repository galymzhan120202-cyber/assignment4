package model;

// PhysicalBook класы BookBase-ден мұра алады
public class PhysicalBook extends BookBase {
    private int weightGrams;

    public PhysicalBook(int id, String name, Author author, int weightGrams) {
        // super() арқылы базалық кластың конструкторын шақыру
        super(id, name, author);
        this.weightGrams = weightGrams;
    }


    @Override
    public String getBookType() {
        return "Physical Printed Book";
    }


    @Override
    public void applyDiscount(double percentage) {
        System.out.println("Applying discount to physical book: " + percentage + "%");
    }

    // Validatable интерфейсінен келген әдісті іске асыру
    @Override
    public void validate() {
        if (getName() == null || getName().isEmpty()) {
            System.out.println("Validation failed: Name cannot be empty.");
        }
        if (weightGrams <= 0) {
            System.out.println("Validation failed: Weight must be positive.");
        }
    }

    @Override
    public double getPrice() {
        return 25.0;
    }

    // Getters and Setters
    public int getWeightGrams() { return weightGrams; }
    public void setWeightGrams(int weightGrams) { this.weightGrams = weightGrams; }
}