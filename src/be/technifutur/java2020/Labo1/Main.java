package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.ActivityControler;
import be.technifutur.java2020.Labo1.activity.ActivityList;
import be.technifutur.java2020.Labo1.activity.ActivityMenu;
import be.technifutur.java2020.Labo1.activity.ActivityVue;
import be.technifutur.java2020.Labo1.stage.StageList;
import be.technifutur.java2020.Labo1.stage.StageVue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Factory factory = new Factory();
        factory.getMainControler().run();




    }

//TODO revoir "optional" -> peut renvoyer quelque chose ou non
//TODO accepter un espace vide pour les setDate;
    //TODO créer exception dans Contributor pour un stage déjà existant et un stage non existant

}


