package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.*;

public class StageEditControler extends MainControler {

    private StageEditMenu menu;

    public void setModel(StageList list) {
        this.list = list;
    }

    public void setMenu(StageEditMenu menu) {
        this.menu = menu;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    @Override
    public void run() {
        String input = null;

        vue.consigneActivityStage();
        vue.displayStages();
        input = scan.nextLine();
        if (stageExists(input)) {
            menu.displayMenu();
            if (menu.getChoice() != null) {
                String key = input.toUpperCase();
                switch (key) {
                    case "1" :
                        vue.consigneDateDebut();
                        break;
                    case "2" :
                        break;
                    case "3" :
                        break;
                    case "Q":
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

}
