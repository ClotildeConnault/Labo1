package be.technifutur.java2020.price;

public class CouplePrice implements Price {

    private double price;
    private final String name = "Prix de couple";

    public String getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price - (price*20/100);
    }

    @Override
    public double getPrice() {
        return price;
    }

}
