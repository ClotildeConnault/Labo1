package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.Vue;
import be.technifutur.java2020.Labo1.contributor.Contributor;
import be.technifutur.java2020.price.Price;
import be.technifutur.java2020.price.StagePriceList;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

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

    public void displayStage(String key) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println(
                this.list.getList().get(key).getName() + " " +
                        this.list.getDateDebut(key).format(formatter) + " " +
                        this.list.getDateFin(key).format(formatter) + "\n"
        );
    }

    public void displayStageSchedule(String key) {

        LocalDate date = LocalDate.of(list.getDateDebut(key).getYear(), list.getDateDebut(key).getMonth(), list.getDateDebut(key).getDayOfMonth());
        String dateInFrench;

        Duration duration = Duration.between(list.getDateDebut(key), list.getDateFin(key));
        long diff = Math.abs(duration.toDays());
        System.out.println(diff);

        TreeMap<LocalDateTime, be.technifutur.java2020.Labo1.activity.Activity> sortedActivities = new TreeMap<>();
        for (be.technifutur.java2020.Labo1.activity.Activity activity : list.getActivities(key).getList().values()) {
            sortedActivities.put(activity.getDateDebut(), activity);
        }

        for (int i = 0; i <= diff; i++) {
            dateInFrench = date.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRENCH));
            System.out.println(dateInFrench);

            for (be.technifutur.java2020.Labo1.activity.Activity activity : sortedActivities.values()) {
                if (activity.getDateDebut().getDayOfYear() == (date.getDayOfYear())) {
                    LocalTime start = LocalTime.of(activity.getDateDebut().getHour(), activity.getDateDebut().getMinute());
                    LocalTime end = start.plusMinutes(activity.getDuree());

                    System.out.println("\t" + start.format(DateTimeFormatter.ofPattern("HH'h'mm")) + " " +
                            end.format(DateTimeFormatter.ofPattern("HH'h'mm")) + " " + activity.getName() + " " + "(" + activity.getDuree() + ")");
                }

            }

            System.out.println("\n");
            date = date.plusDays(1);

        }
    }

    public void displayContributors() {
        for (Contributor c : list.getAllContributors().values()) {
            System.out.println(
                            c.getName() + " " +
                            c.getClub() + " " +
                            c.getEmail()
            );
        }
    }

    public void displayDiscounts(String stageName) {
        StagePriceList stagePriceList = list.getPriceList(stageName);

            for (Price price : stagePriceList.getStagePriceList().values()) {
                System.out.println(price.getName());
            }
    }

    public void noDiscounts() {
        System.out.println("Il n'y a pour l'instant aucune réduction");
    }

    public void demandeAjoutDiscount() {
        System.out.println("Voulez-vous ajouter une réduction ? (O/N)");
    }
    public void demandeSupprDiscount() {
        System.out.println("Voulez-vous supprimer une réduction ? (O/N)");
    }
    public void choixSupprDiscount() {
        System.out.println("Quelle réduction voulez-vous supprimer ?");
    }

    public void demandeDiscount() {
        System.out.println("Voulez-vous ajouter des réductions pour ce stage? (O/N)");
    }

    public void consigneChoixDiscount() {
        System.out.println("Quelle réduction souhaitez-vous rendre disponible pour ce stage?");
    }

    public void discountAdded() {
        System.out.println("La réduction a été ajoutée avec succès");
    }

    public void consigneEditStage() {
        System.out.println("Entrez le nom du stage que vous souhaitez modifier");
    }


    public void consigneAffichePlanning() {
        System.out.println("Entrez le nom du stage dont vous voulez afficher le planning");
    }

    public void consigneContributorStage() {
        System.out.println("Entrez le nom du stage pour lequel vous voulez gérer les contributeurs");
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
        System.out.println("Il n'y a aucun stage existant \n");
    }

    @Override
    public void doesNotExist() {
        System.out.println("Ce stage n'existe pas");
    }
}
