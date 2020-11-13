package be.technifutur.java2020.price;

public class UnemployedPrice implements Price {

    private double price;
    private final String name = "Prix demandeur d'emploi";

    public String getName() {
        return name;
    }
    @Override
    public void setPrice(double price) {
        this.price = price - (price*50/100);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
