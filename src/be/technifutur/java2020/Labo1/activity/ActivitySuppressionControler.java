package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;

public class ActivitySuppressionControler extends Controler {

    private ActivityVue vue;
    private Menu menu;
    private ActivityList list;


    public void setMenu(Menu menu) {
        this.menu = (ActivityMenu) menu;
    }


    public void setModel(List list) {
        this.list = (ActivityList) list;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    @Override
    public void run(String key) {

    }

    @Override
    public void run() {
        System.out.println("ActivitySuppressionControler.run");
    }
}
