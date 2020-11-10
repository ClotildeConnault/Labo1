package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.TreeMap;

public class ActivityControler extends Controler {

    private ActivityVue vue;
    private ActivityMenu menu;
    private TreeMap<ControlerType, Controler> controlerList;
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

    public void addControler(ControlerType key, Controler controler) {
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
                    controlerList.get(ControlerType.ACTIVITYCREATIONCONTROLER).run(key);
                    break;
                case "2":
                    controlerList.get(ControlerType.ACTIVITYMODIFCONTROLER).run();
                    break;
                case "3":
                    controlerList.get(ControlerType.STAGESUPPRESSIONCONTROLER).run();
                    break;
                case "4":
                    vue.displayActivities();
                    break;
                case "q" :
                    controlerList.get(ControlerType.MAINCONTROLER).run();

            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

}
