package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Event {
    protected String name;
    protected LocalDateTime dateDebut;
    protected LocalDateTime dateFin;
    protected int duree;


    public Event(String name){
        this.name = name;
    }

    public void setDateDebut(int year, int month, int day, int hour, int min) throws DateTimeException {
        dateDebut = LocalDateTime.of(year, month, day, hour, min);
        if (dateDebut.isBefore(LocalDateTime.now())) {
            throw new DateTimeException("La date ne peut pas être antérieure à aujourd'hui");
        }
    }

    public LocalDateTime getDateDebut(){
        return dateDebut;
    }

    public LocalDateTime getDateFin(){
        return dateFin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getDuree() {
        return duree;
    }

}
