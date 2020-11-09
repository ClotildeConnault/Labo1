package be.technifutur.java2020.Labo1.activity;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.List;
import be.technifutur.java2020.Labo1.Menu;
import be.technifutur.java2020.Labo1.Vue;
import be.technifutur.java2020.Labo1.stage.StageList;

import java.time.DateTimeException;
import java.util.Scanner;

public class ActivityCreationControler extends Controler {

    private ActivityVue vue;
    //private Menu menu;
    private StageList list;
    private String stageKey;
    private String activityKey;

    public void setModel(StageList list) {
        this.list = list;
    }


   // public void setMenu(Menu menu) {
   //     this.menu = (ActivityMenu) menu;
   // }

    @Override
    public void setVue(Vue vue) {
        this.vue = (ActivityVue) vue;
    }

    public void run() {

    }

    public void run(String key) {
        stageKey = key;
        vue.consigneCreaActivity();

            vue.consigneNomActivity();
            activityKey = scan.nextLine();
            ActivityList activityList = list.getActivities(key);
 //test ---------------------------------------------------------------
        System.out.println("Test" + list.getList().containsKey(key));
        //Fin Test -----------------------------------
            list.addActivity(stageKey, activityKey);
            boolean dateTimeException = false;
            String input = null;

            do {
                dateTimeException = false;
                try {
                    do {
                        vue.consigneDateDebut();
                        input = scan.nextLine();
                    } while (!isDateFormatValid(input));

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

            } while (!isDureeFormatValid(input));
            activityList.setDuree(activityKey, Integer.parseInt(input));
            vue.succes();

    }

}