package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Stage extends Evenement{

    private LocalDate dateFin;
    private LocalTime heureFin;
    private HashMap<Integer, Activite> activites;
   // private List<Inscrit> inscrits;

    public Stage(String name){
        super(name);
        activites = new HashMap<>();
    }

    public void setDateFin(int year, int month, int day) throws DateTimeException {
        dateFin = LocalDate.of(year, month, day);
        if (dateFin.isBefore(this.dateDebut)) {
            throw new DateTimeException("La date de fin est incohérente par rapport à la date de début");
        }
    }

    public LocalDate getDateFin(){
        return dateFin;
    }

    public void setHeureFin(int hour, int minute){
        heureFin = LocalTime.of(hour, minute);
    }

    public LocalTime getHeureFin(){
        return heureFin;
    }


}
