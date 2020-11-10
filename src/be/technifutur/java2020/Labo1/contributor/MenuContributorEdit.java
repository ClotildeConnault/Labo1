package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.Menu;

import java.util.TreeMap;

public class MenuContributorEdit extends Menu {

    public MenuContributorEdit() {

        options = new TreeMap<>();
        options.put("1", "Modifier le nom de l'intervenant");
        options.put("2", "Modifier le prénom de l'intervenant");
        options.put("3", "Modifier l'adresse email");
        options.put("4", "Modifier le club");
        options.put("5", "Ajouter un stage");
        options.put("6", "Supprimer un stage");
        options.put("Q", "Quitter");
    }

}
