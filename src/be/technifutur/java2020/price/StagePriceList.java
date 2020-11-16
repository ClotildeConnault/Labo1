package be.technifutur.java2020.price;

import java.util.HashMap;

public class StagePriceList {

    private HashMap<String, Price> stagePriceList;
    private PriceList priceList;

    public StagePriceList() {
        priceList = new PriceList();
        stagePriceList = new HashMap<>();
    }

    public void addPrice(String priceName) {
        stagePriceList.put(priceName, priceList.getPrice(priceName));
    }

    public void removePrice(String priceName) {
        stagePriceList.remove(priceName);
    }

    public HashMap<String, Price> getStagePriceList() {
        return stagePriceList;
    }

    public Price getStagePrice(String priceName) {
        return stagePriceList.get(priceName);
    }
}
