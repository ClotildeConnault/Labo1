package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;

public class StageModifControler extends Controler {

    private StageVue vue;

    @Override
    public void setModel(List list) {
        this.list = (StageList) list;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    public void run() {
        System.out.println("StageModifControler.jeMarche");
    }
}
