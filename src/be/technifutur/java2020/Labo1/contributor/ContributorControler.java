package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.TreeMap;

public class ContributorControler extends Controler {

    protected ContributorVue vue;
    protected ContributorList contributorList;
    protected MenuContributor menu;
    protected TreeMap<ControlerType, Controler> controlerList;
    protected StageList stageList;
    protected String activeStage;

    @Override
    public void setVue(Vue vue) {
        this.vue = (ContributorVue)vue;
        menu = new MenuContributor();
        controlerList = new TreeMap<>();
    }

    public void setModel(ContributorList list) {
        contributorList = list;
    }
    public void setModel(StageList stageList) {
        this.stageList = stageList;
    }
    public void setActiveStage(String stage) {
        activeStage = stage;
    }
    public void addControler(ControlerType key, Controler controler) {
        controlerList.put(key, controler);
    }


    @Override
    public void run() {

        menu.displayMenu();
        switch(menu.getChoice()) {
            case "1":
                controlerList.get(ControlerType.CONTRIBUTORCREATIONCONTROLER).run();
                break;
            case "2":
                controlerList.get(ControlerType.CONTRIBUTOREDITCONTROLER).run();
                break;
            case "3":
                break;
            case "4" :
                break;
            case "Q":
                controlerList.get(ControlerType.MAINCONTROLER).run();
                break;

        }



    }

}
