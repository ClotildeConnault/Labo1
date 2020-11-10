package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.stage.Stage;

import java.util.TreeMap;

public class MenuPrincipal extends Menu {


    public MenuPrincipal() {
        options = new TreeMap<>();
        options.put("1", "Créer un stage");
        options.put("2", "Modifier un stage");
        options.put("3", "Supprimer un stage");
        options.put("4", "Afficher les stages");
        options.put("5", "Gérer les activités");
        options.put("6", "Afficher le planning d'un stage");
        options.put("7", "Gérer les participants");
        options.put("Q", "Quitter");
    }

    public void displayMenuPrincipal() {

        System.out.print("Bienvenue dans l'assistant de gestion de stages \n " +
                        "Veuillez choisir une des options suivantes \n");
        displayMenu();
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
