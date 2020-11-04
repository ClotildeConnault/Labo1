package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Controler {

    private Model model;
    private Vue vue;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void creationStage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Création d'un nouveau stage");
        System.out.println("Entrez le nom du stage");
        model.addStage(scan.nextLine());
        Integer key = model.getStages().size();
        boolean exception = false;

        do {
            try {
                System.out.println("Entrez une date de début pour le stage (format yyyy mm jj)");
                model.setDateDebut(key, scan.nextInt(), scan.nextInt(), scan.nextInt());
                System.out.println("Entrez une heure de début pour le stage (format hh mm)");
                model.setHeureDebut(key, scan.nextInt(), scan.nextInt());
            } catch (DateTimeException e){
                exception = true;
                System.out.println(e);
            }

        } while (exception);

        do {
            try {
                System.out.println("Entrez une date de fin pour le stage (format yyyy mm jj)");
                model.setDateFin(key, scan.nextInt(), scan.nextInt(), scan.nextInt());
                System.out.println("Entrez une heure de fin pour le stage (format hh mm)");
                model.setHeureFin(key, scan.nextInt(), scan.nextInt());
            } catch (DateTimeException e) {
                exception = true;
                System.out.println(e);
            }

        } while (exception);

    }
}
//TODO vérifier que la date de début est postérieure à la date courante v
//TODO vérifier que la date de fin est postérieure à la date de début v
//TODO vérifier que le format de la date correspond au format yyyy mm dd
//TODO vérifier que le format de l'heure correspond au format hh mm
//TODO gérer les exceptions quand la date début et fin est la même