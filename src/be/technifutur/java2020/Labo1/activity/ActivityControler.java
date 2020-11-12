package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.TreeMap;

public class ActivityControler extends Controler {

    protected ActivityVue vue;
    private ActivityMenu menu;
    private TreeMap<ControlerType, Controler> controlerList;
    protected StageList list;
    protected String activeStage;

    public ActivityControler() {
        controlerList = new TreeMap<>();
    }

    public void setActiveStage(String activeStage) {
        this.activeStage = activeStage;
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
                    controlerList.get(ControlerType.ACTIVITYCREATIONCONTROLER).run();
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
