package be.technifutur.java2020.Labo1;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Vue vue = new Vue();
        StageList stageList = new StageList();
        Controler controler = new Controler();

        controler.setVue(vue);
        controler.setModel(stageList);
        vue.setModel(stageList);

    controler.creationStage();

        vue.afficheStages();

    }


}


