package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.price.StagePriceList;

public class StageEditControler extends MainControler {

    private StageEditMenu editMenu;
    private String activeStage;

    public void setEditMenu(StageEditMenu editMenu) {
        this.editMenu = editMenu;
    }


    @Override
    public void run() {
        String input = null;

        vue.consigneEditStage();
        vue.displayStages();
        input = scan.nextLine();
        if (stageExists(input)) {
            activeStage = input;
            editMenu.displayMenu();
            input = editMenu.getChoice();
            if (input != null) {

                switch (input.toUpperCase()) {
                    case "1" :

                        break;
                    case "2" :
                        setDateDebut(activeStage);
                        setDateFin(activeStage);
                        break;
                    case "3" :
                        if (isEmptyStagePriceList()) {
                            vue.noDiscounts();
                        }
                        else {
                            vue.displayDiscounts(activeStage);
                        }
                        do {
                            vue.demandeAjoutDiscount();
                            input = scan.nextLine();
                        } while (!isONValid(input));

                        if (input.equalsIgnoreCase("o")) {

                        }

                        if (!isEmptyStagePriceList()) {
                            do {
                                vue.demandeSupprDiscount();
                                input = scan.nextLine();
                            } while (!isONValid(input));

                            if (input.equalsIgnoreCase("o")) {

                            }
                        }
                        run();
                        break;
                    case "Q":
                        controlerList.get(ControlerType.MAINCONTROLER).run();
                        break;
                }

            }
            else {
                vue.erreurInputMenu();
            }
        }
        else {
            vue.doesNotExist();
        }
    }

    private boolean isEmptyStagePriceList() {
        boolean isEmpty = false;
        StagePriceList stagePriceList = list.getPriceList(activeStage);
        if (stagePriceList.getStagePriceList().size() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

}
