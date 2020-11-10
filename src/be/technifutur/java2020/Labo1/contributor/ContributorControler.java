package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.*;

import java.util.TreeMap;

public class ContributorControler extends Controler {

    protected ContributorVue vue;
    protected ContributorList contributorList;
    protected MainControler mainControler;
    protected MenuContributor menu;
    protected TreeMap<ControlerType, Controler> controlerList;

    @Override
    public void setVue(Vue vue) {
        this.vue = (ContributorVue)vue;
        menu = new MenuContributor();
        controlerList = new TreeMap<>();
    }

    public void setModel(ContributorList list) {
        contributorList = list;
    }

    public void addControler(ControlerType key, Controler controler) {
        controlerList.put(key, controler);
    }

    public void setControler(MainControler mainControler) {
        this.mainControler = mainControler;
    }

    @Override
    public void run() {

        menu.displayMenu();
        switch(menu.getChoice()) {
            case "1":
                controlerList.get(ControlerType.CONTRIBUTORCREATIONCONTROLER).run();
                break;
            case "2":
                controlerList.get(ControlerType.CONTRIBUTOREDITCONTROLER).run();
                break;
            case "3":
                break;
            case "4" :
                break;
            case "Q":
                mainControler.run();
                break;

        }



    }

    @Override
    public void run(String key) {

    }


}
