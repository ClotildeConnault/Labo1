package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.*;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.TreeMap;

public class ActivityControler extends Controler {

    protected ActivityVue vue;
    private ActivityMenu menu;
    protected TreeMap<ControlerType, Controler> controlerList;
    protected StageList stageList;
    protected String activeStage;
    protected ActivityList activityList;

    public void setActivityList() {
        activityList = stageList.getActivities(activeStage);
    }

    public ActivityControler() {
        controlerList = new TreeMap<>();
    }

    public void setActiveStage(String activeStage) {
        this.activeStage = activeStage;
        setActivityList();
        for (Controler c : controlerList.values()) {
            if (c instanceof ActivityControler) {
                ((ActivityControler) c).setActiveStage(activeStage);
            }
        }
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    public void setMenu(ActivityMenu menu) {
        this.menu = menu;
    }

    public void setModel(StageList list) {
        this.stageList = list;
    }

    public void addControler(ControlerType key, Controler controler) {
        controlerList.put(key, controler);
    }

    public void run() {
        String input = null;
        do {
            vue.setActiveStage(activeStage);
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
                case "5":
                    vue.selectActivity();
                    input = scan.nextLine();
                    if (existsActivity(input)) {
                        ((ActivityRegisterControler)controlerList.get(ControlerType.ACTIVITYREGISTERCONTROLER)).setActiveActivity(input);
                        controlerList.get(ControlerType.ACTIVITYREGISTERCONTROLER).run();
                    }
                    break;
                case "q" :
                    controlerList.get(ControlerType.MAINCONTROLER).run();

            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

    private boolean existsActivity(String key) {
        boolean exists = true;
        if (!stageList.getList().get(activeStage).existsActivity(key)){
            exists = false;
            vue.doesNotExist();
        }
        return exists;
    }

}
