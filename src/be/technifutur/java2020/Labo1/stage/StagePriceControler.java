package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.MainControler;

public class StagePriceControler extends MainControler {

    private StagePriceMenu priceMenu;
    private String activeStage;

    public void setPriceMenu(StagePriceMenu menu) {
        this.priceMenu = menu;
    }

    public void setActiveStage(String stageName) {
        activeStage = stageName;
    }

    public void run() {

        String input = null;
        do {
            vue.consigneChoixDiscount();
            priceMenu.displayMenu();
            input = priceMenu.getChoice();
            if (input == null) {
                vue.erreurInputMenu();
            }
        } while (input == null);

        if (!input.equalsIgnoreCase("q")) {
            list.addPrice(activeStage, priceMenu.getOptionName(input));
            vue.discountAdded();
            run();
        }
        else {
            super.run();
        }


    }
}
