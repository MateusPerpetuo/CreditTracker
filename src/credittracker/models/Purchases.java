package credittracker.models;

public class Purchases implements Comparable<Purchases> {
    private String description;
    private  double price;

    // Constructor

    public Purchases(String description, double price) {
        this.description = description;
        this.price = price;
    }

    // Getters

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Purchases: Description: " + description + '\'' +
                ", price $" + price;
    }



    @Override
    public int compareTo(Purchases purchases) {
        return Double.compare(this.price, purchases.getPrice());
    }
}
