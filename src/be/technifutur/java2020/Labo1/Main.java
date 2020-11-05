package be.technifutur.java2020.Labo1;

public class Main {
    public static void main(String[] args) {
        Vue vue = new Vue();
        StageList stageList = new StageList();
        Controler controler = new Controler();

        controler.setVue(vue);
        controler.setModel(stageList);
        vue.setModel(stageList);

    controler.creationStage();
        controler.creationStage();
        controler.creationStage();

        vue.afficheStages();







    }


}
