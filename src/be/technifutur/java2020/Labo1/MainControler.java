package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.ActivityControler;
import be.technifutur.java2020.Labo1.activity.ActivityCreationControler;
import be.technifutur.java2020.Labo1.stage.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class MainControler extends Controler {

    protected StageList list;
    protected StageVue vue;
    private MenuPrincipal menu;
    private TreeMap<ControlerType, Controler> controlerList;

    public MainControler() {
        controlerList = new TreeMap<>();
    }

    public void setModel(StageList list) {
        this.list = list;
    }
    public void setMenu(MenuPrincipal menu) {
        this.menu = menu;
    }
    public void addControler(ControlerType key, Controler controler) {
        controlerList.put(key, controler);
    }


    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    @Override
    public void run(String key) {

    }

    @Override
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
                    controlerList.get(ControlerType.STAGECREATIONCONTROLER).run();
                    break;
                case "2":
                    controlerList.get(ControlerType.STAGEMODIFCONTROLER).run();
                    break;
                case "3":
                    controlerList.get(ControlerType.STAGESUPPRESSIONCONTROLER).run();
                    break;
                case "4":
                    if (!list.getList().isEmpty()) {
                        vue.displayStages();
                    }
                    else {
                        vue.noStages();
                    }
                    break;
                case "5":
                    if (!list.getList().isEmpty()) {
                        vue.consigneChoixStage();
                        vue.displayStages();
                        String nomStage = scan.nextLine();

                        if (!list.getList().containsKey(nomStage)) {
                            vue.doesNotExist();
                        }
                        else {
                            controlerList.get(ControlerType.ACTIVITYCONTROLER).run(nomStage);
                        }
                    }
                    else {
                        vue.noStages();
                    }
                    break;
                case "6":
                    if(list.getList().isEmpty()) {
                        vue.noStages();
                    }
                    else {
                        vue.displayStages();
                        vue.consigneAffichePlanning();
                        input = scan.nextLine();
                        if (stageExists(input)) {
                            vue.displayStageSchedule(input);
                        }
                    }
                    break;
                case "7":
                    controlerList.get(ControlerType.CONTRIBUTORCONTROLER).run();
                    break;

            }

        } while (!input.equalsIgnoreCase("q"));

        vue.messageSortie();
    }

   public boolean stageExists(String key) {
        boolean exists = true;
        if(!list.getList().containsKey(key)) {
            vue.doesNotExist();
            exists = false;
        }
        return exists;
    }

}
