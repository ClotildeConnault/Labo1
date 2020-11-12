package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ActivityCreationControler extends ActivityControler {

    private String activityKey;
    private LocalDateTime dateTest;

    public void setModel(StageList list) {
        this.list = list;
    }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    public void run() {

    }

    public void run(String key) {

        vue.consigneCreaActivity();

            vue.consigneNomActivity();
            activityKey = scan.nextLine();
            ActivityList activityList = list.getActivities(key);
            list.addActivity(activeStage, activityKey);
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

            } while (!isDureeFormatValid(input) || !isDureeValid(activeStage, input));

            activityList.setDuree(activityKey, Integer.parseInt(input));
            vue.succes();

    }

    private boolean isDateValid(String nomStage, LocalDateTime date) {
        boolean isValid = true;

        if ((!date.isAfter(list.getDateDebut(nomStage)) && !date.equals(list.getDateDebut(nomStage))
                || !date.isBefore(list.getDateFin(nomStage)))){
            isValid = false;
            System.out.println("La date de début doit être comprise dans la durée du stage");
        }
        return isValid;
    }

    private boolean isDureeValid(String nomStage, String duree) {
        boolean isValid = true;
        int d = Integer.parseInt(duree);
        LocalDateTime test = list.getDateDebut(nomStage).plusMinutes((long)d);

        if (test.isAfter(list.getDateFin(nomStage))) {
            isValid = false;
            System.out.println("La durée de l'activité doit être comprise dans la durée du stage");
        }
        return isValid;
    }

}