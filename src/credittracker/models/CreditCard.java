package credittracker.models;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchases> purchasesList;

    // Constructor

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchasesList = new ArrayList<>();
    }

    // Methods

    public boolean logPurchase(Purchases purchase){
        if (this.balance > purchase.getPrice()) {
            this.balance -= purchase.getPrice();
            this.purchasesList.add(purchase);
            return  true;
        }else {
            return false;
        }
    }

    // Getters

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchases> getPurchasesList() {
        return purchasesList;
    }
}
