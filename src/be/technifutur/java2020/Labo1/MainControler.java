package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.stage.*;

public class MainControler extends Controler {

    private MenuPrincipal menu;
    private Controler c;
    private StageVue vue;


    @Override
    public void setMenu(Menu menu) {
        this.menu = (MenuPrincipal)menu;
    }

    @Override
    public void setModel(List list) {
        this.list = (StageList) list;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue)vue;
    }

    @Override
    public void run() {
        String input = null;
        do {
            menu.displayMenuPrincipal();
            input = null;

            do {
                input = menu.getChoice();
                if (input == null) {
                    vue.erreurInputMenu();
                    menu.displayMenuPrincipal();
                }
            } while (input == null);

            switch (input) {
                case "1":
                    c = new StageCreationControler();
                    c.setVue(vue);
                    c.setModel((StageList) list);
                    c.run();
                    break;
                case "2":
                    c = new StageModifControler();
                    c.run();
                    break;
                case "3":
                    c = new StageSuppressionControler();
                    c.run();
                    break;
                case "4":
                    vue.afficheStages();
                    break;
                case "5":

                    break;
            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

}
