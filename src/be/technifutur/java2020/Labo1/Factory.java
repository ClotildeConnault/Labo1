package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.*;
import be.technifutur.java2020.Labo1.contributor.*;
import be.technifutur.java2020.Labo1.stage.*;

import java.util.Arrays;
import java.util.TreeMap;

public class Factory {

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



    public MainControler getMainControler() {
        if(mainControler == null) {
            mainControler = new MainControler();
            mainControler.setVue(getStageVue());
            mainControler.setModel(getStageList());
            mainControler.setMenu(getMenuPrincipal());
            mainControler.addControler(ControlerType.STAGECREATIONCONTROLER, getStageCreationControler());
            mainControler.addControler(ControlerType.STAGEMODIFCONTROLER, getStageModifControler());
            mainControler.addControler(ControlerType.STAGESUPPRESSIONCONTROLER, getStageSuppressionControler());
            mainControler.addControler(ControlerType.ACTIVITYCONTROLER, getActivityControler());
            mainControler.addControler(ControlerType.CONTRIBUTORCONTROLER, getContributorControler());
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

    public StageEditControler getStageModifControler() {
        if (stageEditControler == null) {
            stageEditControler = new StageEditControler();
            stageEditControler.setMenu(stageEditMenu);
        }
        return stageEditControler;
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
            activityControler.addControler(ControlerType.ACTIVITYCREATIONCONTROLER, getActivityCreationControler());
            activityControler.addControler(ControlerType.MAINCONTROLER, getMainControler());
            activityControler.addControler(ControlerType.ACTIVITYREGISTERCONTROLER, getActivityRegisterControler());

        }
        return activityControler;
    }

    private ActivityRegisterControler getActivityRegisterControler() {
        if (activityRegisterControler == null) {
            activityRegisterControler = new ActivityRegisterControler();
            activityRegisterControler.setMenu(new ActivityRegisterMenu());
            activityRegisterControler.setModel(getStageList());
            activityRegisterControler.setVue(getActivityVue());
            activityRegisterControler.addControler(ControlerType.CONTRIBUTORCONTROLER, getContributorControler());
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
            contributorControler.addControler(ControlerType.CONTRIBUTORCREATIONCONTROLER, getContributorCreationControler());
            contributorControler.addControler(ControlerType.CONTRIBUTOREDITCONTROLER, getContributorEditControler());
            contributorControler.addControler(ControlerType.MAINCONTROLER, getMainControler());

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
            contributorCreationControler.addControler(ControlerType.CONTRIBUTOREDITCONTROLER, getContributorEditControler());
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

    public TestUser getTestUser() {
        String[] testInput = new String[]{
                "1",
                "Stage de jeu de rôle",//stage
                "2020 12 12 09 00",
                "2020 12 18 18 00",
                "5",
                "Stage de jeu de rôle",//stage
                "Création de personnages",
                "2020 12 12 09 00",
                "120",
                "6",
                "Stage de jeu de rôle"
        };
        return new TestUser(Arrays.asList(testInput).iterator());
    }

    public static void main(String[] args) {
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
}


