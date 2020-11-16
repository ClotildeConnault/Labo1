package be.technifutur.java2020.Labo1;

import be.technifutur.java2020.Labo1.stage.StageList;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Controler implements Runnable {

    protected Pattern datePattern = Pattern.compile("[0-9][0-9][0-9][0-9]\\h[0-1][0-9]\\h[0-3][0-9]\\h[0-9][0-9]\\h[0-9][0-9]");
    protected Pattern dureePattern = Pattern.compile("[0-9]+");
    protected Scanner scan = new Scanner(System.in);
    protected ControlerType type;
    protected TreeSet<ControlerType> generalType;
    protected ControlerList controlerList;

    public Controler() {
        generalType = new TreeSet<>();
        controlerList = new ControlerList();
    }

    public void setControlerList(ControlerList controlerList) {
        this.controlerList = controlerList;
    }

    public ControlerType getType() {
        return type;
    }
    public TreeSet<ControlerType> getGeneralType() {return generalType;}

    public abstract void setVue(Vue vue);
    public abstract void setModel(StageList stageList);

    public void addControler(Controler controler) {
        controlerList.addControler(controler);
    }

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

    public abstract void run();

    public boolean isONValid(String input) {
        return input.equalsIgnoreCase("o")||input.equalsIgnoreCase("n");
    }




}