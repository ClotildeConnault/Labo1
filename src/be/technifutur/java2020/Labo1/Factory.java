package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.*;
import be.technifutur.java2020.Labo1.contributor.*;
import be.technifutur.java2020.Labo1.stage.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import javax.naming.ldap.Control;
import java.io.*;
import java.util.Arrays;

public class Factory {
    public static final String filepath="C:\\Users\\cloti\\OneDrive\\Documents\\Java base\\java2020Labo1\\src\\be\\technifutur\\java2020\\backup.save";
    private MainControler mainControler;
    private StageCreationControler stageCreationControler;
    private StageEditControler stageEditControler;
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
    private StageEditMenu stageEditMenu;
    private ContributorControler contributorControler;
    private ContributorList contributorList;
    private ContributorCreationControler contributorCreationControler;
    private ContributorEditControler contributorEditControler;
    private ContributorVue contributorVue;
    private ActivityRegisterControler activityRegisterControler;
    private StagePriceControler stagePriceControler;
    private ControlerList controlerList;
    private StagePlanningDisplayControler stagePlanningDisplayControler;
    private StageDisplayControler stageDisplayControler;

    public ControlerList getControlerList() {
        if (controlerList == null) {
            controlerList = new ControlerList();
            controlerList.addControler(getMainControler());
            controlerList.addControler(getStageCreationControler());
            controlerList.addControler(getStagePriceControler());
            controlerList.addControler(getStageEditControler());
            controlerList.addControler(getStageSuppressionControler());
            controlerList.addControler(getContributorControler());
            controlerList.addControler(getContributorCreationControler());
            controlerList.addControler(getContributorEditControler());
            controlerList.addControler(getActivityCreationControler());
            controlerList.addControler(getActivityRegisterControler());
            controlerList.addControler(getStageDisplayControler());
            controlerList.addControler(getStagePlanningDisplayControler());
            controlerList.addControler(getActivityControler());

        }

        return controlerList;
    }

    public void setControlerLists() {

        ControlerList subList = new ControlerList();
        for (Controler controler : getControlerList().getValues()) {

            for (Controler c : controlerList.getValues()) {
               System.out.println(controler.getType() + " " + controler.getGeneralType() + " " + c.getType() + " " + c.getGeneralType());
                if (controler.getGeneralType().last() == c.getGeneralType().first()) {
                    controler.addControler(c);
                }

            }
            subList.getControlerList().clear();
        }
    }

    public StageDisplayControler getStageDisplayControler() {
        if (stageDisplayControler == null) {
            stageDisplayControler = new StageDisplayControler();
            stageDisplayControler.setModel(getStageList());
            stageDisplayControler.setVue(getStageVue());
        }

        return stageDisplayControler;
    }

    public StagePlanningDisplayControler getStagePlanningDisplayControler() {
        if (stagePlanningDisplayControler == null) {
            stagePlanningDisplayControler = new StagePlanningDisplayControler();
            stagePlanningDisplayControler.setModel(getStageList());
            stagePlanningDisplayControler.setVue(getStageVue());
        }
        return stagePlanningDisplayControler;
    }

    public StagePriceControler getStagePriceControler() {
        if (stagePriceControler == null) {
            stagePriceControler = new StagePriceControler();
            //stagePriceControler.setMenu(getMenuPrincipal());
            stagePriceControler.setPriceMenu(new StagePriceMenu());
            stagePriceControler.setVue(getStageVue());
            stagePriceControler.setModel(getStageList());
        }
        return stagePriceControler;
    }

    public MainControler getMainControler() {
        if(mainControler == null) {
            getControlerList();
            mainControler = new MainControler();
            mainControler.setVue(getStageVue());
            mainControler.setModel(getStageList());
            //mainControler.setMenu(getMenuPrincipal());
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
            stageList.setContributorList(getContributorList());
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

    public StageEditControler getStageEditControler() {
        if (stageEditControler == null) {
            stageEditControler = new StageEditControler();
            stageEditControler.setEditMenu(new StageEditMenu());
            stageEditControler.setVue(getStageVue());
            stageEditControler.setModel(getStageList());
           // stageEditControler.setMenu(getMenuPrincipal());

        }
        return stageEditControler;
    }

    public StageSuppressionControler getStageSuppressionControler() {
        if (stageSuppressionControler == null) {
            stageSuppressionControler = new StageSuppressionControler();
            stageSuppressionControler.setModel(getStageList());
            stageSuppressionControler.setVue(getStageVue());
        }
        return stageSuppressionControler;
    }

    public ActivityControler getActivityControler() {
        if (activityControler == null) {
            activityControler = new ActivityControler();
            activityControler.setVue(getActivityVue());
            activityControler.setModel(getStageList());
            activityControler.addControler(getMainControler());

        }
        return activityControler;
    }

    private ActivityRegisterControler getActivityRegisterControler() {
        if (activityRegisterControler == null) {
            activityRegisterControler = new ActivityRegisterControler();
            activityRegisterControler.setMenu(new ActivityRegisterMenu());
            activityRegisterControler.setModel(getStageList());
            activityRegisterControler.setVue(getActivityVue());
            activityRegisterControler.setContributorList(getContributorList());
            activityRegisterControler.addControler(getActivityControler());
        }
        return activityRegisterControler;
    }

    public ActivityVue getActivityVue() {
        if (activityVue == null) {
            activityVue = new ActivityVue();
            activityVue.setModel(getStageList());
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
            activityCreationControler.addControler(getActivityControler());
        }
        return activityCreationControler;
    }

    public ContributorList getContributorList() {
        if (contributorList == null) {
            contributorList = new ContributorList();
        }
        return contributorList;
    }

    public ContributorControler getContributorControler() {
        if (contributorControler == null) {
            contributorControler = new ContributorControler();
            contributorControler.setVue(getContributorVue());
            contributorControler.setModel(getContributorList());
            contributorControler.setModel(getStageList());
            contributorControler.addControler(getMainControler());

        }
        return contributorControler;
    }

    private Controler getContributorEditControler() {
        if (contributorEditControler == null) {
            contributorEditControler = new ContributorEditControler();
            contributorEditControler.setVue(contributorVue);
            contributorEditControler.setModel(getContributorList());

        }
        return contributorEditControler;
    }

    private ContributorCreationControler getContributorCreationControler() {
        if (contributorCreationControler == null) {
            contributorCreationControler = new ContributorCreationControler();
            contributorCreationControler.setVue(getContributorVue());
            contributorCreationControler.setModel(getContributorList());
            contributorCreationControler.setModel(getStageList());
            contributorCreationControler.addControler(getContributorControler());
        }
        return contributorCreationControler;
    }


    private ContributorVue getContributorVue() {
        if (contributorVue == null) {
            contributorVue = new ContributorVue();
            contributorVue.setModel(getContributorList());
        }
        return contributorVue;
    }


    public StageEditMenu getStageModifMenu() {
        if (stageEditMenu == null) {
            stageEditMenu = new StageEditMenu();
        }
        return stageEditMenu;
    }








       /* StageList list = new StageList();
        list.add("bla");
        list.setDateDebut("bla", 2020, 12, 12, 02, 02);
        list.setDateFin("bla", 2020, 12, 15, 02, 02);
        StageVue vue = new StageVue();
        vue.setModel(list);
        list.addActivity("bla", "Truc");
        list.getActivities("bla").setDateDebut("Truc", 2020, 12, 14, 05, 00);
        list.getActivities("bla").setDuree("Truc", 120);
        list.addActivity("bla", "Bidule");
        list.getActivities("bla").setDateDebut("Bidule", 2020, 12, 14, 01, 00);
        list.getActivities("bla").setDuree("Bidule", 102);
        list.addActivity("bla", "Machin");
        list.getActivities("bla").setDateDebut("Machin", 2020, 12, 14, 03, 00);
        list.getActivities("bla").setDuree("Machin", 35);
        vue.displayStageSchedule("bla"); */



}


