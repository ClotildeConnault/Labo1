package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.TreeMap;

public class ActivityControler extends Controler {

    protected ActivityVue vue;
    protected StageList stageList;
    protected String activeStage;
    protected ActivityList activityList;

    public void setActivityList() {
        activityList = stageList.getActivities(activeStage);
    }

    public ActivityControler() {
        type = ControlerType.ACTIVITYCONTROLER;
        generalType.add(ControlerType.STAGE);
        generalType.add(ControlerType.ACTIVITY);
    }

    public void setActiveStage(String stageName) {
        this.activeStage = stageName;


      /*  for (Controler c : controlerList.getValues()) {
            System.out.println(c);
            if (c instanceof ActivityControler) {
                ((ActivityControler) c).setActiveStage(activeStage);
            }
        } */
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    public void setModel(StageList list) {
        this.stageList = list;
    }

    public void run() {
        String input = null;
        Menu menu = new Menu(controlerList.getControlerList());

        if (!stageList.getList().isEmpty()) {
            vue.consigneActivityStage();
            vue.displayStages();
            String stageName = scan.nextLine();

            if (!stageList.getList().containsKey(stageName)) {
                vue.doesNotExist();
            }
            else {
                this.activeStage = stageName;
                ((ActivityControler)controlerList.getControler(ControlerType.ACTIVITYCREATIONCONTROLER)).setActiveStage(stageName);
                ((ActivityControler)controlerList.getControler(ControlerType.ACTIVITYREGISTERCONTROLER)).setActiveStage(stageName);
                setActivityList();
                vue.setActiveStage(activeStage);
            }
        }
        else {
            vue.noStages();
            controlerList.getControler(ControlerType.MAINCONTROLER).run();
        }


        do {
            menu.displayMenu();
            input = null;

            do {
                input = menu.getChoice();
                if (input == null) {
                    vue.erreurInputMenu();
                    menu.displayMenu();
                }
            } while (input == null);

            ((Controler)menu.getOption(input)).run();

        } while (!input.equalsIgnoreCase("q"));


    }

    protected boolean existsActivity(String key) {
        boolean exists = true;
        if (!stageList.getList().get(activeStage).existsActivity(key)){
            exists = false;
            vue.doesNotExist();
        }
        return exists;
    }

    @Override
    public String toString() {
        return "Gérer les activités";
    }
}
