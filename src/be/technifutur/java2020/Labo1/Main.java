package be.technifutur.java2020.Labo1;

public class Main {
    public static void main(String[] args) {
        Vue vue = new Vue();
        StageList list = new StageList();
        MainControler controler = new MainControler();

        controler.setVue(vue);
        controler.setModel(list);
        vue.setModel(list);

    controler.run();



    }
//TODO créer un contrôleur par type d'action pour Activity (créer, supprimer, etc)//TODO créer le menu pour Activity
//TODO relier les contrôleurs d'Activity au menu
//TODO revoir "optional" -> peut renvoyer quelque chose ou non
// TODO créer la fabrique

}


