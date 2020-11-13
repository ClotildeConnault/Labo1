package be.technifutur.java2020.price;

import java.io.Serializable;

public interface Price extends Serializable {

    void setPrice(double price);
    double getPrice();
    String getName();
}
