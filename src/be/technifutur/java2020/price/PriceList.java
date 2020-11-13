package be.technifutur.java2020.price;

import java.io.Serializable;
import java.util.HashMap;

public class PriceList implements Serializable {

    private HashMap<String, Price> pricelist;

    public PriceList() {
        pricelist = new HashMap<>();
        pricelist.put("Prix enseignant", new TeacherPrice());
        pricelist.put("Prix de couple", new CouplePrice());
        pricelist.put("Prix demandeur d'emploi", new UnemployedPrice());
    }

    public Price getPrice(String price) {
        return pricelist.get(price);
    }

    public int getSize() {
        return pricelist.size();
    }

    public HashMap<String, Price> getPricelist() {
        return pricelist;
    }
}
