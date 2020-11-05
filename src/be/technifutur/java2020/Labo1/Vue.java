package be.technifutur.java2020.Labo1;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Vue {

    private StageList stageList;

    public void setModel(StageList stageList){
        this.stageList = stageList;
    }

    public void afficheStages(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Liste des stages");
        System.out.println();
        System.out.println("nom du stage" + "   " + "début du stage" + "   " + "fin du stage");


        for (Map.Entry<String, Stage> entry : stageList.getStages().entrySet()) {
            System.out.print(
                    entry.getKey() + " " +
                    stageList.getDateDebut(entry.getKey()).format(formatter) + " " +
                            stageList.getDateFin(entry.getKey()).format(formatter)
            );
            System.out.println();
        }
    }

    public void afficheStage(String key) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println(
                        this.stageList.getStages().get(key).getName() + " " +
                        this.stageList.getDateDebut(key).format(formatter) + " " +
                        this.stageList.getDateFin(key).format(formatter) + "\n"
        );
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
}
