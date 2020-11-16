package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.price.Price;
import be.technifutur.java2020.price.PriceList;

import java.util.TreeMap;

public class StagePriceMenu extends Menu {

    private PriceList priceList;

    public StagePriceMenu() {
        priceList = new PriceList();
        options = new TreeMap<>();
        int i = 1;

        for (Price price : priceList.getPricelist().values()) {
            options.put(String.valueOf(i), price.getName());
            i++;
        }
        options.put("Q", "Retour");
    }

    public String getOptionName(String key) {
        return (String)options.get(key);
    }
}
