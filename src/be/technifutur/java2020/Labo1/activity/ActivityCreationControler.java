package be.technifutur.java2020.Labo1.activity;
import be.technifutur.java2020.Labo1.ControlerType;
import be.technifutur.java2020.Labo1.Vue;
import be.technifutur.java2020.Labo1.stage.StageList;
import java.time.DateTimeException;
import java.time.LocalDateTime;


public class ActivityCreationControler extends ActivityControler {

    private String activityKey;
    private LocalDateTime dateTest;


    public ActivityCreationControler() {
        type = ControlerType.ACTIVITYCREATIONCONTROLER;
        generalType.clear();
        generalType.add(ControlerType.ACTIVITY);
    }

    public void setModel(StageList list) {
        this.stageList = list;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    public void run() {

        vue.consigneCreaActivity();

            vue.consigneNomActivity();
            activityKey = scan.nextLine();


            stageList.addActivity(activeStage, activityKey);
        this.activityList = stageList.getActivities(activeStage);
            boolean dateTimeException = false;
            String input = null;

            do {
                dateTimeException = false;
                try {
                    do {
                        do {
                            vue.consigneDateDebut();
                            input = scan.nextLine();
                        } while (!isDateFormatValid(input));

                        dateTest = LocalDateTime.of(
                                Integer.valueOf(input.substring(0, 4)),
                                Integer.valueOf(input.substring(5, 7)),
                                Integer.valueOf(input.substring(8, 10)),
                                Integer.valueOf(input.substring(11, 13)),
                                Integer.valueOf(input.substring(14))
                        );

                    } while (!isDateValid(activeStage, dateTest));


                    activityList.setDateDebut(
                            activityKey,
                            Integer.valueOf(input.substring(0, 4)),
                            Integer.valueOf(input.substring(5, 7)),
                            Integer.valueOf(input.substring(8, 10)),
                            Integer.valueOf(input.substring(11, 13)),
                            Integer.valueOf(input.substring(14))
                    );

                } catch (DateTimeException e) {
                    dateTimeException = true;
                    System.out.println(e);
                }

            } while (dateTimeException);

            do {

                vue.consigneDuree();
                input = scan.nextLine();

            } while (!isDureeFormatValid(input) || !isDureeValid(input));

            activityList.setDuree(activityKey, Integer.parseInt(input));
            vue.succes();

    }

    private boolean isDateValid(String nomStage, LocalDateTime date) {
        boolean isValid = true;

        if ((!date.isAfter(stageList.getDateDebut(nomStage)) && !date.equals(stageList.getDateDebut(nomStage))
                || !date.isBefore(stageList.getDateFin(nomStage)))){
            isValid = false;
            System.out.println("La date de début doit être comprise dans la durée du stage");
        }
        return isValid;
    }

    private boolean isDureeValid(String duree) {
        boolean isValid = true;
        int d = Integer.parseInt(duree);

        LocalDateTime test = activityList.getDateDebut(activityKey).plusMinutes((long)d);

        if (test.isAfter(stageList.getDateFin(activeStage))) {
            isValid = false;
            System.out.println("La durée de l'activité doit être comprise dans la durée du stage");
        }
        return isValid;
    }

    @Override
    public String toString() {
        return "Créer une activité";
    }

}