package be.technifutur.java2020.Labo1.stage;

import be.technifutur.java2020.Labo1.Event;
import be.technifutur.java2020.Labo1.activity.Activity;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.HashMap;


public class Stage extends Event {

    private LocalDateTime dateFin;
    private HashMap<Integer, Activity> activites;
   // private List<Inscrit> inscrits;

    public Stage(String name){
        super(name);
        activites = new HashMap<>();
    }

    public void setDateFin(int year, int month, int day, int hour, int min) throws DateTimeException {
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, min);
        if (date.isBefore(this.dateDebut)) {
            throw new DateTimeException("La date de fin est incohérente par rapport à la date de début");
        }
        else {
            dateFin = date;
        }
    }

    public LocalDateTime getDateFin(){
        return dateFin;
    }



}
