package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;

public class ActivityModifControler extends Controler {

    private ActivityVue vue;

    @Override
    public void setMenu(Menu menu) {
        this.menu = (ActivityMenu) menu;
    }

    @Override
    public void setModel(List list) {
        this.list = (ActivityList) list;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    @Override
    public void run() {
        System.out.println("ActivityModifControler.run");
    }
}
