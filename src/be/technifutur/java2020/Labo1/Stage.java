package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Stage extends Evenement{

    private LocalDateTime dateFin;
    private HashMap<Integer, Activite> activites;
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
