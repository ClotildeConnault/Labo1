package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Vue;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class StageVue extends Vue {

    private StageList list;

    public void setModel(StageList list) {
        this.list = list;
    }

    public void displayStages() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Liste des stages");
        System.out.println();
        System.out.println("nom du stage" + "   " + "début du stage" + "   " + "fin du stage");


        for (Map.Entry<String, ? extends Event> entry : list.getList().entrySet()) {
            System.out.print(
                    entry.getKey() + " " +
                            list.getDateDebut(entry.getKey()).format(formatter) + " " +
                            list.getDateFin(entry.getKey()).format(formatter)
            );
            System.out.println();
        }
    }

    public void afficheStage(String key) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println(
                this.list.getList().get(key).getName() + " " +
                        this.list.getDateDebut(key).format(formatter) + " " +
                        this.list.getDateFin(key).format(formatter) + "\n"
        );
    }

    public void consigneChoixStage() {
        System.out.println("Entrez le nom du stage auquel vous voulez ajouter une activité");
    }

    public void consigneCreaStage() {
        System.out.println("Création d'un nouveau stage\n");
    }

    public void consigneDateDebut() {
        System.out.println("Entrez une date et une heure de début pour le stage (format aaaa mm jj hh mm)");
    }

    public void consigneDateFin() {
        System.out.println("Entrez une date et une heure de fin pour le stage (format aaaa mm jj hh mm)");
    }

    public void consigneNomStage() {
        System.out.println("Entrez le nom du stage");
    }

    public void succes() {
        System.out.print("Création réussie ");
    }

    public void erreurInputMenu() {
        System.out.println("Cette valeur ne correspond à aucune option");
    }

    public void messageSortie() {
        System.out.println("A bientôt");
    }

    public void noStages() {
        System.out.println("Il n'y a aucun stage existant");
    }

    @Override
    public void doesNotExist() {
        System.out.println("Ce stage n'existe pas");
    }
}
