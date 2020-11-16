package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;

public class StageSuppressionControler extends Controler {

    private StageList list;
    private Menu menu;

    public StageSuppressionControler() {
        type = ControlerType.STAGESUPPRESSIONCONTROLER;
        generalType.add(ControlerType.STAGE);
    }

    public void setModel(StageList list) {
        this.list = list;
    }

    @Override
    public void setVue(Vue vue) {
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        System.out.println("StageSuppressionControler.jeMarche");
        controlerList.getControler(ControlerType.MAINCONTROLER).run();
    }

    public String toString() {
        return "Supprimer un stage";
    }
}
