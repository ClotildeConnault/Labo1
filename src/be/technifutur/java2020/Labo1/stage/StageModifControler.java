package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.*;

public class StageModifControler extends Controler {

    private StageVue vue;
    private Menu menu;
    private List list;

    public void setModel(List list) {
        this.list = (StageList) list;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    @Override
    public void run(String key) {

    }

    public void run() {
        System.out.println("StageModifControler.jeMarche");
    }
}
