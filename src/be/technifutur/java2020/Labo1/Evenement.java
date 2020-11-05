package be.technifutur.java2020.Labo1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Evenement {
    protected String name;
    protected LocalDateTime dateDebut;


    public Evenement(String name){
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
