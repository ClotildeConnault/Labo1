package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Menu;

import java.util.TreeMap;

public class ActivityMenu extends Menu {

    public ActivityMenu() {
        options = new TreeMap<>();
        options.put("1", "Créer une activité");
        options.put("2", "Modifier une activité");
        options.put("3", "Supprimer une activité");
        options.put("4", "Afficher les activités");
        options.put("Q", "Quitter");
    }

    public void displayMenuPrincipal() {

        System.out.print("Bienvenue dans l'assistant de gestion des activités \n " +
                "Veuillez choisir une des options suivantes \n");
        displayMenu();
    }

    public static void main(String[] args) {
        ActivityMenu menu = new ActivityMenu();
        menu.displayMenuPrincipal();
    }
}
