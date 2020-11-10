package be.technifutur.java2020.Labo1.contributor;

import be.technifutur.java2020.Labo1.Menu;

import java.util.TreeMap;

public class MenuContributor extends Menu {

    public MenuContributor() {

        options = new TreeMap<>();
        options.put("1", "Ajouter un nouvel intervenant");
        options.put("2", "Modifier un intervenant");
        options.put("3", "Supprimer un intervenant");
        options.put("4", "Afficher les intervenants");
        options.put("Q", "Quitter");
    }
}
