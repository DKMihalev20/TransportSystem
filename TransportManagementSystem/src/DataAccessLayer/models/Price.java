package DataAccessLayer.models;
public class Price {
    private int priceId;
    private double price;

    public Price() {

    }
    public Price(double price) {
        this.price = price;
    }
    public Price(int priceId, double price) {
        this.priceId = priceId;
        this.price = price;
    }
    public int getPriceId() {
        return priceId;
    }
    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
