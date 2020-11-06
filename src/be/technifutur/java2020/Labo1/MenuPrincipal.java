package be.technifutur.java2020.Labo1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MenuPrincipal extends Menu {


    public MenuPrincipal() {
        options = new TreeMap<>();
        options.put("1", "Créer un stage");
        options.put("2", "Modifier un stage");
        options.put("3", "Supprimer un stage");
        options.put("4", "Afficher les stages");
        options.put("5", "Gérer les activités");
        options.put("Q", "Quitter");
    }

    public void displayMenuPrincipal() {

        System.out.print("Bienvenue dans l'assistant de gestion de stages \n " +
                        "Veuillez choisir une des options suivantes \n");
        displayMenu();
    }



    public String getChoice() {
        input = scan.nextLine().toUpperCase();
        if(!options.containsKey(input)) {
            input = null;
        }
        return input;
    }


  /*  public void displayMenuModifier(Stage stage) {
        System.out.print("Modification du stage " + stage.getName() + "\n " +
                "Veuillez choisir une des options suivantes \n" +
                "1 - Changer la date de début \n" +
                "2 - Changer la date de fin \n" +
                "3 - Supprimer un stage \n" +
                "Q - Quitter"
        );
    } */



    public static void main(String[] args) {
        Stage stage = new Stage("blu");
        MenuPrincipal menu = new MenuPrincipal();
        menu.displayMenuPrincipal();

    }
}
