package be.technifutur.java2020.price;

public class TeacherPrice implements Price {

    private double price;
    private final String name = "Prix enseignant";

    public String getName() {
        return name;
    }
    @Override
    public void setPrice(double price) {
        this.price = price - (price*40/100);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
