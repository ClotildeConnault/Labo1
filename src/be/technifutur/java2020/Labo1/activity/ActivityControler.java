package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;
import be.technifutur.java2020.Labo1.stage.StageCreationControler;
import be.technifutur.java2020.Labo1.stage.StageList;
import be.technifutur.java2020.Labo1.stage.StageModifControler;
import be.technifutur.java2020.Labo1.stage.StageSuppressionControler;

public class ActivityControler extends Controler {

    private ActivityVue vue;
    private ActivityMenu menu;
    private Controler c;

    @Override
    public void setModel(List list) {
        this.list = (ActivityList) list;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = (ActivityMenu) menu;
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
                    c = new ActivityCreationControler();
                    c.setVue(vue);
                    c.setModel(list);
                    c.run();
                    break;
                case "2":
                    c = new ActivityModifControler();
                    c.run();
                    break;
                case "3":
                    c = new ActivitySuppressionControler();
                    c.run();
                    break;
                case "4":
                    vue.displayActivities();
                    break;
            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

}
