package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.TreeMap;

public class ContributorControler extends MainControler {

    protected ContributorVue vue;
    protected ContributorList contributorList;
    protected Menu menu;
    protected String activeStage;

    public ContributorControler() {
        type = ControlerType.CONTRIBUTORCONTROLER;
        generalType.clear();
        generalType.add(ControlerType.STAGE);
        generalType.add(ControlerType.CONTRIBUTOR);
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ContributorVue)vue;
    }

    public void setModel(ContributorList list) {
        contributorList = list;
    }
    public void setModel(StageList stageList) {
        this.list = stageList;
    }
    public ContributorList getContributorList() {
        return contributorList;
    }

    public void setActiveStage(String stage) {
        activeStage = stage;
        for (Controler c : controlerList.getValues()) {
            if (c instanceof ContributorControler) {
                ((ContributorControler)c).setActiveStage(stage);
            }
        }
    }


    @Override
    public void run() {

        String input;

        menu = new Menu(controlerList.getControlerList());
        menu.displayMenu();

        do {
            input = menu.getChoice();
            if (input == null) {
                vue.erreurInputMenu();
                menu.displayMenu();
            }
        } while (input == null);

        ((Controler)menu.getOption(input)).run();

        /*switch(menu.getChoice()) {
            case "1":
                controlerList.get(ControlerType.CONTRIBUTORCREATIONCONTROLER).run();
                break;
            case "2":
                controlerList.get(ControlerType.CONTRIBUTOREDITCONTROLER).run();
                break;
            case "3":
                break;
            case "4" :
                vue.displayContributors();
                break;
            case "Q":
                controlerList.get(ControlerType.MAINCONTROLER).run();
                break;

        } */

    }

    @Override
    public String toString() {
        return "Gérer les participations";
    }
}
