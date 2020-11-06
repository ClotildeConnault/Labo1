package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Controler implements Runnable {

    protected List list;
    protected Menu menu;
    protected Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]\\h[0-1][0-9]\\h[0-3][0-9]\\h[0-9][0-9]\\h[0-9][0-9]");

    public abstract void setModel(List list);

    public abstract void setVue(Vue vue);

   public abstract void setMenu(Menu menu);

    protected boolean isDateFormatValid(String input) throws PatternSyntaxException {
        Matcher matcher = this.datePattern.matcher(input);
        boolean isValid = true;

        if (!matcher.matches()) {
            System.out.println("La date saisie n'est pas conforme au format (aaaa mm jj hh mm)");
            isValid = false;
        }
        return isValid;
    }

    public abstract void run();
}
