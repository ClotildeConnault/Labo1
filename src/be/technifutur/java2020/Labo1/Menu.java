package be.technifutur.java2020.Labo1;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    String input = null;

    /*public void displayMenuGeneral() {
        templateMenuGeneral();
        input = scan.nextLine();

        while (!input.equalsIgnoreCase('q')) {
            int option = Integer.valueOf(input);

            switch(option) {
                case 1 :

                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :

                    break;
            }
        }


    } */

    public void templateMenuGeneral() {
        System.out.print("Bienvenue dans l'assistant de gestion de stages \n " +
                        "Veuillez choisir une des options suivantes \n" +
                        "1 - Créer un stage \n" +
                        "2 - Modifier un stage \n" +
                        "3 - Supprimer un stage \n" +
                        "4 - Afficher les stages \n" +
                        "Q - Quitter"
                );
    }

    public void templateMenuModifier(Stage stage) {
        System.out.print("Modification du stage " + stage.getName() + "\n " +
                "Veuillez choisir une des options suivantes \n" +
                "1 - Changer la date de début \n" +
                "2 - Changer la date de fin \n" +
                //"3 - Supprimer un stage \n" +
                "Q - Quitter"
        );
    }



    /*public static void main(String[] args) {
        Stage stage = new Stage("blu");
        Menu menu = new Menu();
        menu.displayMenuGeneral();
        menu.displayMenuModifier(stage);
    }*/
}
