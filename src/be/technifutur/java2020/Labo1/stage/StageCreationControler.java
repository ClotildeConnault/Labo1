package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Controler;
import be.technifutur.java2020.Labo1.Vue;

import java.time.DateTimeException;
import java.util.Scanner;

public class StageCreationControler extends Controler {

    private StageVue vue;
    private StageList list;

    @Override
    public void setVue(Vue vue) {
        this.vue = (StageVue) vue;
    }

    public void setModel(StageList list) {
        this.list = list;
    }

    public void run(){

        Scanner scan = new Scanner(System.in);
        vue.consigneCreaStage();
        vue.consigneNomStage();
        String key = scan.nextLine();
        list.add(key);
        boolean dateTimeException = false;
        String input = null;

        do {
            dateTimeException = false;
            try {
                do {
                    vue.consigneDateDebut();
                    input = scan.nextLine();
                } while (!isDateFormatValid(input));

                list.setDateDebut(
                        key,
                        Integer.valueOf(input.substring(0, 4)),
                        Integer.valueOf(input.substring(5, 7)),
                        Integer.valueOf(input.substring(8, 10)),
                        Integer.valueOf(input.substring(11, 13)),
                        Integer.valueOf(input.substring(14))
                );


            } catch (DateTimeException e){
                dateTimeException = true;
                System.out.println(e);
            }

        } while (dateTimeException);

        do {
            dateTimeException = false;
            try {
                do {
                    vue.consigneDateFin();
                    input = scan.nextLine();
                } while (!isDateFormatValid(input));

                list.setDateFin(
                        key,
                        Integer.valueOf(input.substring(0, 4)),
                        Integer.valueOf(input.substring(5, 7)),
                        Integer.valueOf(input.substring(8, 10)),
                        Integer.valueOf(input.substring(11, 13)),
                        Integer.valueOf(input.substring(14))
                );

            } catch (DateTimeException e){
                dateTimeException = true;
                System.out.println(e);
            }

        } while (dateTimeException);

        vue.succes();
        vue.displayStage(key);

    }

}