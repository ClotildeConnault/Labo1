package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Vue;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ActivityVue extends Vue {

    @Override
    public void setModel(List list) {
        this.list = (ActivityList) list;
    }
    //public void SetModel(ActivityList list){
    //    list = list;
    //}
    public void displayActivities() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Liste des activités");
        System.out.println();
        System.out.println("nom de l'activité" + "   " + "début de l'activité" + "   " + "durée de l'activité");



        for (Map.Entry<String, ? extends Event> entry : list.getList().entrySet()) {
            System.out.print(
                    entry.getKey() + " " +
                            list.getDateDebut(entry.getKey()).format(formatter) + " "
            );
            System.out.println();
        }
    }

    public void afficheStage(String key) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println(
                this.list.getList().get(key).getName() + " " +
                        this.list.getDateDebut(key).format(formatter) + " "
        );
    }

    public void consigneCreaActivity() {
        System.out.println("Création d'une nouvelle activité\n");
    }

    public void consigneDateDebut() {
        System.out.println("Entrez une date et une heure de début pour l'activité' (format aaaa mm jj hh mm)");
    }

    public void consigneDuree() {
        System.out.println("Entrez une durée pour l'activité (en minutes)");
    }

    public void consigneNomStage() {
        System.out.println("Entrez le nom de l'activité");
    }



}
