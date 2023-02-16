
public class Product {
    private String description;
    private double costPrice;
    private double sellingPrice;
    private double profitMargin;
    private double taxes;
    private int quantity;
    private int minimumQuantity;

    public Product(String description, double costPrice, double profitMargin, int quantity, int minimumQuantity) {
        this.description = description;
        this.costPrice = costPrice;
        this.profitMargin = profitMargin;
        this.taxes = 0.18 * (costPrice + profitMargin);
        this.sellingPrice = costPrice + profitMargin + taxes;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
        this.taxes = 0.18 * (costPrice + profitMargin);
        this.sellingPrice = costPrice + profitMargin + taxes;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
        this.taxes = 0.18 * (costPrice + profitMargin);
        this.sellingPrice = costPrice + profitMargin + taxes;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public double getTaxes() {
        return taxes;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public boolean isBelowMinimumQuantity() {
        return quantity < minimumQuantity;
    }
}
