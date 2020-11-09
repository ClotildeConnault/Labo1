package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.*;
import be.technifutur.java2020.Labo1.stage.*;

public class Factory {

    private MainControler mainControler;
    private StageCreationControler stageCreationControler;
    private StageModifControler stageModifControler;
    private StageSuppressionControler stageSuppressionControler;
    private StageVue stageVue;
    private StageList stageList;
    private MenuPrincipal menuPrincipal;
    private ActivityControler activityControler;
    private ActivityCreationControler activityCreationControler;
    private ActivityModifControler activityModifControler;
    private ActivitySuppressionControler activitySuppressionControler;
    private ActivityVue activityVue;
    private ActivityMenu activityMenu;



    public MainControler getMainControler() {
        if(mainControler == null) {
            mainControler = new MainControler();
            mainControler.setVue(getStageVue());
            mainControler.setModel(getStageList());
            mainControler.setMenu(getMenuPrincipal());
            mainControler.addControler("1", getStageCreationControler());
            mainControler.addControler("2", getStageModifControler());
            mainControler.addControler("3", getStageSuppressionControler());
            mainControler.addControler("5", getActivityControler());
        }
        return mainControler;
    }

    public StageVue getStageVue() {
        if (stageVue == null) {
            stageVue = new StageVue();
            stageVue.setModel(getStageList());
        }
        return stageVue;
    }

    public StageList getStageList() {
        if (stageList == null) {
            stageList = new StageList();
        }
        return stageList;
    }

    public MenuPrincipal getMenuPrincipal() {
        if (menuPrincipal == null) {
            menuPrincipal = new MenuPrincipal();
        }
        return menuPrincipal;
    }

    public StageCreationControler getStageCreationControler() {
        if (stageCreationControler == null) {
            stageCreationControler = new StageCreationControler();
            stageCreationControler.setVue(getStageVue());
            stageCreationControler.setModel(getStageList());
        }
        return stageCreationControler;
    }

    public StageModifControler getStageModifControler() {
        if (stageModifControler == null) {
            stageModifControler = new StageModifControler();
        }
        return stageModifControler;
    }

    public StageSuppressionControler getStageSuppressionControler() {
        if (stageSuppressionControler == null) {
            stageSuppressionControler = new StageSuppressionControler();
        }
        return stageSuppressionControler;
    }

    public ActivityControler getActivityControler() {
        if (activityControler == null) {
            activityControler = new ActivityControler();
            activityControler.setMenu(getActivityMenu());
            activityControler.setVue(getActivityVue());
            activityControler.setModel(getStageList());
            activityControler.addControler("1", getActivityCreationControler());

        }
        return activityControler;
    }

    public ActivityVue getActivityVue() {
        if (activityVue == null) {
            activityVue = new ActivityVue();
        }
        return activityVue;
    }

    public ActivityMenu getActivityMenu() {
        if (activityMenu == null) {
            activityMenu = new ActivityMenu();
        }
        return activityMenu;
    }

    public ActivityCreationControler getActivityCreationControler() {
        if (activityCreationControler == null) {
            activityCreationControler = new ActivityCreationControler();
            activityCreationControler.setModel(getStageList());
            activityCreationControler.setVue(getActivityVue());
        }
        return activityCreationControler;
    }
}
