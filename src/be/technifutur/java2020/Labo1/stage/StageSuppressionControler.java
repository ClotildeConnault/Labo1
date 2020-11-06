package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;

public class StageSuppressionControler extends Controler {

    @Override
    public void setModel(List list) {
        this.list = (StageList) list;
    }

    @Override
    public void setVue(Vue vue) {
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        System.out.println("StageSuppressionControler.jeMarche");
    }
}
