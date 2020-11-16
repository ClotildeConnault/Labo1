package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.Vue;

public class StageDisplayControler extends Controler {

    private StageVue vue;
    private StageList list;

    public StageDisplayControler() {
        type = ControlerType.STAGEDISPLAYCONTROLER;
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
        if (!list.getList().isEmpty()) {
            vue.displayStages();
        }
        else {
            vue.noStages();
        }
    }

    @Override
    public String toString() {
        return "Afficher la liste des stages";
    }
}
