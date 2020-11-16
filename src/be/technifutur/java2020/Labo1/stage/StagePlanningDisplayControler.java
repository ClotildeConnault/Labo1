package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.Vue;

public class StagePlanningDisplayControler extends Controler {

    private StageVue vue;
    private StageList list;

    public StagePlanningDisplayControler() {
        type = ControlerType.STAGEPLANNINGDISPLAYCONTROLER;
        generalType.add(ControlerType.STAGE);
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue)vue;
    }

    @Override
    public void setModel(StageList stageList) {
        list = stageList;
    }

    @Override
    public void run() {
        String input;

        if (list.getList().isEmpty()) {
            vue.noStages();
        }
        else {
            vue.displayStages();
            vue.consigneAffichePlanning();
            input = scan.nextLine();
            if (stageExists(input)) {
                vue.displayStageSchedule(input);
            }
            else {
                vue.doesNotExist();
            }
        }

    }

    @Override
    public String toString() {
        return "Afficher le planning d'un stage";
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
