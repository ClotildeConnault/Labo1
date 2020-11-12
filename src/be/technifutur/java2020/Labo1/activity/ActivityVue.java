package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Vue;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ActivityVue extends Vue {

    private ActivityList activityList;
    private StageList stageList;
    private String activeStage;

    public void setModel(StageList stageList) {
        this.stageList = stageList;
    }

    public void setActivityList() {
        activityList = stageList.getActivities(activeStage);
    }

    public void setActiveStage(String stageName) {
        activeStage = stageName;
        setActivityList();
    }

    public void displayActivities() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Liste des activités");
        System.out.println();
        System.out.println("nom de l'activité" + "   " + "début de l'activité" + "   " + "durée de l'activité");



        for (Map.Entry<String, be.technifutur.java2020.Labo1.activity.Activity> entry : activityList.getList().entrySet()) {
            System.out.print(
                    entry.getKey() + " " +
                            activityList.getDateDebut(entry.getKey()).format(formatter) + " "
            );
            System.out.println();
        }
    }

    public void afficheStage(String key) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println(
                this.activityList.getList().get(key).getName() + " " +
                        this.activityList.getDateDebut(key).format(formatter) + " "
        );
    }

    public void consigneCreaActivity() {
        System.out.println("Création d'une nouvelle activité\n"
                );
    }

    public void consigneDateDebut() {
        System.out.println("Entrez une date et une heure de début pour l'activité' (format aaaa mm jj hh mm)");
    }

    public void consigneDuree() {
        System.out.println("Entrez une durée pour l'activité (en minutes)");
    }

    public void consigneNomActivity() {
        System.out.println("Entrez le nom de l'activité");
    }

    public void selectActivity() {
        System.out.println("Entrez le nom de l'activité pour laquelle vous voulez gérer les inscriptions");
    }

    public void doesNotExist() {
        System.out.println("Cette activité n'existe pas");
    }

    public void doesNotExistContributor() {
        System.out.println("Cet intervenant n'existe pas");
    }

    public void consigneContributorName() {
        System.out.println("Entrez le nom du participant que vous voulez inscrire");
    }

}
