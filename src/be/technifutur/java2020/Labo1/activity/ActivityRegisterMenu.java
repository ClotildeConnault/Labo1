package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Menu;

import java.util.TreeMap;

public class ActivityRegisterMenu extends Menu {

    public ActivityRegisterMenu() {
        options = new TreeMap<>();
        options.put("1", "Inscrire un participant");
        options.put("2", "Désinscrire un participant");
        options.put("3", "Afficher les participants");
        options.put("Q", "Retour au menu principal");
    }
}
