package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.activity.Activity;
import be.technifutur.java2020.Labo1.stage.StageList;
import be.technifutur.java2020.Labo1.stage.StageVue;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Controler implements Runnable {

    //protected StageList list;
    protected Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]\\h[0-1][0-9]\\h[0-3][0-9]\\h[0-9][0-9]\\h[0-9][0-9]");
    protected Pattern dureePattern = Pattern.compile("[0-9]+");
    protected Scanner scan = new Scanner(System.in);

    //public void setModel(StageList list) {
    //    this.list = list;
    //}

    public abstract void setVue(Vue vue);

    //public abstract void setMenu(Menu menu);

    protected boolean isDateFormatValid(String input) throws PatternSyntaxException {
        Matcher matcher = this.datePattern.matcher(input);
        boolean isValid = true;

        if (!matcher.matches()) {
            System.out.println("La date saisie n'est pas conforme au format (aaaa mm jj hh mm)");
            isValid = false;
        }
        return isValid;
    }

    protected boolean isDureeFormatValid(String input) {
        Matcher matcher = this.dureePattern.matcher(input);
        boolean isValid = true;

        if (!matcher.matches()) {
            System.out.println("La durée saisie n'est pas valide");
            isValid = false;
        }
        return isValid;
    }

    public abstract void run(String key);

    //public abstract String run();

}