package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Controler {

    private StageList stageList;
    private Vue vue;
    private Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]\\h[0-1][0-9]\\h[0-3][0-9]\\h[0-9][0-9]\\h[0-9][0-9]");

    public void setModel(StageList stageList) {
        this.stageList = stageList;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void creationStage(){

        Scanner scan = new Scanner(System.in);
        vue.consigneCreaStage();
        vue.consigneNomStage();
        String key = scan.nextLine();
        stageList.add(key);
        boolean dateTimeException = false;
        boolean patternSyntaxException = false;
        String input = null;

        do {
            dateTimeException = false;
            try {
                do {
                    patternSyntaxException = false;
                    vue.consigneDateDebut();
                    input = scan.nextLine();
                    try {
                        isDateFormatValid(input);
                    } catch (PatternSyntaxException e) {
                        patternSyntaxException = true;
                        System.out.println(e);
                    }
                } while (patternSyntaxException);

                stageList.setDateDebut(
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
                    patternSyntaxException = false;
                    vue.consigneDateFin();
                    input = scan.nextLine();
                    try {
                        isDateFormatValid(input);
                    } catch (PatternSyntaxException e) {
                        patternSyntaxException = true;
                        System.out.println(e);
                    }
                } while (patternSyntaxException);

                stageList.setDateFin(
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
        vue.afficheStage(key);

    }

    private boolean isDateFormatValid(String input) throws PatternSyntaxException {
        Matcher matcher = this.datePattern.matcher(input);
        if (!matcher.matches()) {
            throw new PatternSyntaxException("La date saisie n'est pas conforme au format (aaaa mm jj hh mm)", input, -1);
        }
        return matcher.matches();
    }

}
//TODO virer le double de la boucle do while dégueulasse
//TODO gérer les exceptions quand la date début et fin est la même
//TODO créer un menu
//TODO créer un contrôleur par type d'action (créer, supprimer, etc)
//TODO créer une classe ActiviteList, la faire descendre de List (StageList aussi)
