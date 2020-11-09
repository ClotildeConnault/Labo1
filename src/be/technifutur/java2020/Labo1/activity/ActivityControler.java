package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageCreationControler;
import be.technifutur.java2020.Labo1.stage.StageList;
import be.technifutur.java2020.Labo1.stage.StageModifControler;
import be.technifutur.java2020.Labo1.stage.StageSuppressionControler;

import java.util.TreeMap;

public class ActivityControler extends Controler {

    private ActivityVue vue;
    private ActivityMenu menu;
    private TreeMap<String, Controler> controlerList;
    private StageList list;

    public ActivityControler() {
        controlerList = new TreeMap<>();
    }


    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    public void setMenu(ActivityMenu menu) {
        this.menu = menu;
    }

    public void setModel(StageList list) {
        this.list = list;
    }

    public void addControler(String key, Controler controler) {
        controlerList.put(key, controler);
    }

    @Override
    public void run(){

    }

    public void run(String key) {
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
                    //test ---------------------------------------------------------------
                    System.out.println("Test" + list.getList().containsKey(key));
                    //Fin Test -----------------------------------
                    System.out.println("PV");
                    controlerList.get("1").run(key);
                    System.out.println("PV out");
                    break;
                case "2":
                    controlerList.get("2").run();
                    break;
                case "3":
                    controlerList.get("3").run();
                    break;
                case "4":
                    vue.displayActivities();
                    break;
            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

}
